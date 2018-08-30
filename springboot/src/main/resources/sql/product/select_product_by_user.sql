SELECT pd.product_id AS productId,
       acc.user_name AS userName,
       us.first_name AS firstName,
       us.last_name AS lastName,
       ca.category_code AS categoryCode,
       ca.category_name AS categoryName,
       pd.price AS price,
       pd.amount AS amount,
       (pd.price * pd.amount) AS total,
       pd.regist_time AS registTime
FROM account acc
INNER JOIN userInfo us ON acc.user_name = us.user_name
AND acc.delete_flag = 0
INNER JOIN product pd ON acc.user_name = pd.user_name
AND pd.delete_flag = 0
INNER JOIN category ca ON ca.category_id = pd.category_id
AND ca.delete_flag = 0
## Where
:condition
LIMIT :offset,
      :numberRecord