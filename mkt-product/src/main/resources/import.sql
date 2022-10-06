INSERT INTO tb_category(name) VALUES('Fantasy');
INSERT INTO tb_category(name) VALUES('Science Fiction');
INSERT INTO tb_category(name) VALUES('Historica Fiction');
INSERT INTO tb_category(name) VALUES('Biography');
INSERT INTO tb_category(name) VALUES('Refrence Book');

INSERT INTO tb_product(name,description, price, status) VALUES('Harry Potter', 'A fantasy mage history',99.99,'Sotck in');
INSERT INTO tb_product(name,description, price, status) VALUES('Dhamer', 'A psicopat history',25.66,'Out Sotck');
INSERT INTO tb_product(name,description, price, status) VALUES('History of Computer', 'A computer world history',50.00,'Pending');

INSERT INTO tb_product_category(product_id, category_id) VALUES(1,1);
INSERT INTO tb_product_category(product_id, category_id) VALUES(2,4);
INSERT INTO tb_product_category(product_id, category_id) VALUES(3,5);



