ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME default NOW();