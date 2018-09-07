SELECT count(*)
FROM account acc
INNER JOIN customer cs ON acc.customer_id = cs.customer_id
WHERE acc.user_name=:userName
    AND acc.delete_flag=0