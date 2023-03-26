CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total_movies INT;
    SET total_movies := (
        SELECT COUNT(m.title) AS 'history_movies'
        FROM movies AS m
        JOIN genres_movies AS gm
            ON m.id = gm.movie_id # movies = genres_movies
        JOIN movies_actors AS ma
            ON m.id = ma.movie_id # movies = movies_actors
        JOIN genres AS g
            on gm.genre_id = g.id # genre = genre_movies
        JOIN actors AS a
            ON ma.actor_id = a.id
        WHERE CONCAT_WS(' ', a.first_name, a.last_name) = full_name
          AND g.name = 'History'
        );
    RETURN total_movies;
END;