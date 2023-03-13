ALTER TABLE minions
ADD COLUMN town_id INT(11);

ALTER TABLE minions
ADD CONSTRAINT fk_minions_id FOREIGN KEY(town_id) REFERENCES towns(id);