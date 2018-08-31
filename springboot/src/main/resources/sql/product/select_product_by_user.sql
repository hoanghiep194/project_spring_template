SELECT pd.product_id AS productId,
       ca.category_code AS categoryCode,
       ca.category_name AS categoryName,
       pd.price AS price,
       pd.amount AS amount,
       (pd.price * pd.amount) AS total,
       pd.regist_time AS registTime
FROM product pd
INNER JOIN category ca ON ca.category_id = pd.category_id
AND pd.delete_flag = 0 AND ca.delete_flag = 0
## Where
:condition
LIMIT :offset,
      :numberRecord