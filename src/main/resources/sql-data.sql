INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('basketball', 12.99);
INSERT INTO `ims`.`orders`(`fk_cid`, `fk_pid`, `date_order_placed`) VALUES (1, 1, '2020-05-06');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('adam', 'stevenson');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('football', 8.99);
INSERT INTO `ims`.`orders`(`fk_cid`, `fk_pid`, `date_order_placed`) VALUES (2, 2, '2020-05-08');

INSERT INTO `ims`.`orders`(`fk_cid`, `fk_pid`, `date_order_placed`) VALUES (1, 2, '2020-05-06');
INSERT INTO `ims`.`orders`(`fk_cid`, `fk_pid`, `date_order_placed`) VALUES (2, 1, '2020-05-08');

INSERT INTO `ims`.`orderline` (`order_id`, `fk_pid`) VALUES(1, 1);
INSERT INTO `ims`.`orderline` (`order_id`, `fk_pid`) VALUES(2, 2);