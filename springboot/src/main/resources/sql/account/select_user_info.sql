SELECT us.user_name     AS userName,
       us.first_name    AS firstName,
       us.last_name     AS lastName,
       us.birthday      AS birthday,
       us.sex           AS sex,
       us.email_address AS emailAddress,
       us.address       AS address,
       us.phone         AS phone
FROM userInfo us
WHERE user_name = :userName