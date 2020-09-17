INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('basketball', 12.99);
INSERT INTO `ims`.`orders`(`fk_cid`) VALUES (1);
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('adam', 'stevenson');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('football', 8.99);
INSERT INTO `ims`.`orders`(`fk_cid`) VALUES (2);

INSERT INTO `ims`.`orders`(`fk_cid`) VALUES (1);
INSERT INTO `ims`.`orders`(`fk_cid`) VALUES (2);

INSERT INTO `ims`.`orderline` (`order_id`, `fk_pid`) VALUES(1, 1);
INSERT INTO `ims`.`orderline` (`order_id`, `fk_pid`) VALUES(2, 2);