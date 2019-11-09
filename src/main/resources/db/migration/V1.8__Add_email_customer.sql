ALTER TABLE customers
ADD COLUMN email VARCHAR(30);

UPDATE customers
SET email='wanggege0121@gamil.com'
WHERE
ID=1;

UPDATE customers
SET email='yutongchen@gamil.com'
WHERE
ID=2;

UPDATE customers
SET email='huang@gamil.com'
WHERE
ID=3;

ALTER TABLE customers
ALTER COLUMN email SET NOT NULL;
