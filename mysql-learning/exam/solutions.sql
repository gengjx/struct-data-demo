-- 你把“考核题”的作答SQL写在这个文件里（可多条语句，以 ; 分隔）
CREATE TABLE IF NOT EXISTS coupons(
    id  bigint(20) auto_increment primary key ,
    code varchar(100) not null ,
    discount_cents int(10) not null ,
    status tinyint(2) ,
    created_at bigint(20),
    UNIQUE KEY uniq_code(code)
) ;

# insert into
#     users(username, email)
# values ("gengjiaxin","ggengjx@163.com");



select *
from users where status =1 order by created_at desc limit 2;


select users.username,count(orders.id) from users
    left join orders on users.id = orders.user_id
    group by users.id


select count(orders.id),DATE(created_at)
    from orders
    where created_at >= '2025-01-01' and created_at<='2025-01-08'
    group by (DATE (created_at));


select
    o.id as order_id,o.user_id,u.username,
    o.total_cents,o.status,item.price_cents,item.product_id,
    p.name,p.sku
from orders o left join users u on o.user_id = u.id
left join order_items item on o.id = item.order_id
left join products p on item.product_id = p.id
;

SELECT o.id AS order_id,
       u.username,
       o.status AS order_status,
       o.total_cents,
       p.sku,
       oi.quantity
FROM orders o
         JOIN users u ON u.id = o.user_id
         JOIN order_items oi ON oi.order_id = o.id
         JOIN products p ON p.id = oi.product_id
ORDER BY o.id, oi.id;


select u.id,u.username from users u left join orders on u.id = orders.user_id

group by u.id HAVING count(orders.id) >= 2;

select *
from orders;

update orders set status = "CANCELED" where created_at <= "2025-01-06 12:00:00";

show create table orders;
select * from users;
delete from users u where u.id not in ( select distinct(orders.user_id) from orders) ;



