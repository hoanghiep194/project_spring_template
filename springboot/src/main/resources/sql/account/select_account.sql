SELECT acc.user_name AS userName,
       us.password AS password,
       acc.role_id AS roleId,
       us.first_name AS firstName,
       us.last_name AS lastName
FROM account acc
INNER JOIN userInfo us ON acc.user_name = us.user_name
AND acc.delete_flag = us.delete_flag
WHERE acc.user_name=:userName
    AND acc.delete_flag=0