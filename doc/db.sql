CREATE DATABASE `blive` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE `blive`.`t_demo`  (
                                     `id` int(10) NOT NULL AUTO_INCREMENT,
                                     `name` varchar(50) NOT NULL,
                                     PRIMARY KEY (`id`)
);

insert blive.t_demo
values (1, "Allen");