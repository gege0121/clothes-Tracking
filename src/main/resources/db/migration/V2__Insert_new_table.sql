insert into customers(name, age, gender, height, weight, primer)values
('Gege Wang', 25, 1, 165, 55, 0),
('Yutong Chen', 24, 1, 163, 45, 1),
('Xingyue Huang', 27, 0, 160, 45, 2);
commit;

insert into clothess(type, color, size, tag,customer_id )values
('blouse', 'white', 's', 'business casual', 1),
('skirt', 'black', 's', ' ', 1),
('jeans', 'blue', 's', 'daily', 2),
('dress', 'pink', 'm', 'party', 3);
commit;


insert into historys(customer_id, date, temperature, clothes_id )values
(1, '2019-01-21', 79, 1),
(2, '2019-12-10', 80, 2),
(3, '2019-11-01', 69, 3);
commit;