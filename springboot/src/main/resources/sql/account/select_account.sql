SELECT acc.user_name    AS userName,
       acc.password     AS password,
       acc.role_id      AS roleId,
       cs.first_name    AS firstName,
       cs.last_name     AS lastName,
       cs.customer_id   AS customerId
FROM account acc
INNER JOIN customer cs ON acc.customer_id = cs.customer_id
AND acc.delete_flag = 0 and c.delete_flag = 0
WHERE acc.user_name=:userName
