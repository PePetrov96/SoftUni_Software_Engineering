SELECT starting_point AS 'route_starting_point',
       end_point AS 'route_ending_point',
       leader_id,
       CONCAT_WS(' ', first_name, last_name) AS 'leader_name'
FROM routes AS r
JOIN campers c
ON c.id = r.leader_id;