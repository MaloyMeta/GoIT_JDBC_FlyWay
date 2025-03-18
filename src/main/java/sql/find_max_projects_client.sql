SELECT NAME, COUNT(project_worker.PROJECT_ID) AS PROJECT_COUNT 
FROM worker
LEFT JOIN project_worker ON worker.ID = project_worker.WORKER_ID
GROUP BY worker.NAME
HAVING COUNT(project_worker.PROJECT_ID) = (
    SELECT MAX(PROJECT_COUNT)
    FROM (
        SELECT COUNT(project_worker.PROJECT_ID) AS PROJECT_COUNT
        FROM worker
        LEFT JOIN project_worker ON worker.ID = project_worker.WORKER_ID
        GROUP BY worker.NAME
    ) AS subquery
);
