SELECT acc.user_name AS userName,
       acc.password AS password
FROM account acc
WHERE acc.user_name=:userName