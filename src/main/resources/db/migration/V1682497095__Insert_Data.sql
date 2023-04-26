insert into brand(brand_id, brand_name) values(1, 'ZARA');
insert into product(product_id, product_name) values(35455, 'product1');
insert into prices(price_list, priority, curr, price, start_date, end_date, brand_id, product_id) values(1, 0, 'EUR', 35.50, '2020-06-14 00.00.00', '2020-12-31 23.59.59',
                                                                                                         (select id from brand where brand_name = 'ZARA'),
                                                                                                         (select id from product where product_name='product1'));
insert into prices(price_list, priority, curr, price, start_date, end_date, brand_id, product_id) values(2, 1, 'EUR', 25.45, '2020-06-14 15.00.00', '2020-06-14 18.30.00',
                                                                                                         (select id from brand where brand_name = 'ZARA'),
                                                                                                         (select id from product where product_name='product1'));
insert into prices(price_list, priority, curr, price, start_date, end_date, brand_id, product_id) values(3, 1, 'EUR', 30.50, '2020-06-15 00.00.00', '2020-06-15 11.00.00',
                                                                                                         (select id from brand where brand_name = 'ZARA'),
                                                                                                         (select id from product where product_name='product1'));
insert into prices(price_list, priority, curr, price, start_date, end_date, brand_id, product_id) values(4, 1, 'EUR', 38.95, '2020-06-15 16.00.00', '2020-12-31 23.59.59',
                                                                                                         (select id from brand where brand_name = 'ZARA'),
                                                                                                         (select id from product where product_name='product1'));