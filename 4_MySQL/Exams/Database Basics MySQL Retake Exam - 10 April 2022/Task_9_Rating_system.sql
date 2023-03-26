SELECT m.title,
       (CASE
           WHEN mai.rating <= 4 THEN 'poor'
           WHEN mai.rating <= 7 THEN 'good'
           ELSE 'excellent'
        END) AS 'rating',
       (IF(mai.has_subtitles = 1, 'english', '-')) AS 'subtitles',
       mai.budget
FROM movies AS m
JOIN movies_additional_info AS mai
    ON mai.id = m.movie_info_id
ORDER BY mai.budget DESC;