INSERT INTO userInfo
        (user_name,
         first_name,
         last_name,
         password,
         birthday,
         sex,
         email_address,
         address,
         phone,
         regist_user,
         regist_time,
         update_user,
         update_time,
         delete_flag)
VALUES (:userName,
        :firstName,
        :lastName,
        :password,
        :birthday,
        :sex,
        :emailAddress,
        :address,
        :phone,
        :registUser,
        :registTime,
        :updateUser,
        :updateTime,
        :deleteFlag);