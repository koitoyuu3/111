DROP TABLE IF EXISTS `directory`;
CREATE TABLE `directory`
(
    `id`    bigint(20) NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) DEFAULT '#',
    `phone` varchar(255) DEFAULT '0',
    `email` varchar(255) DEFAULT '0',

    PRIMARY KEY (`id`)
);