SELECT id,
       first_name,
       last_name,
       birthdate,
       card,
       review
FROM clients
ORDER BY birthdate DESC, id DESC;