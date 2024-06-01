SELECT *
FROM task t
JOIN planner.user u on u.id = t.user_id
WHERE user_id = 1;