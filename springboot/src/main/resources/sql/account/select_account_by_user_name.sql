SELECT count(*)
FROM account acc
INNER JOIN userInfo us ON acc.user_name = us.user_name
WHERE acc.user_name=:userName
    AND acc.delete_flag=0