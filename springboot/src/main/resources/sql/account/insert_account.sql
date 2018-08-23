INSERT INTO account
        (user_name,
         password,
         expiry_date,
         delete_expired_account,
         mail_address,
         role_id,
         register_user,
         register_time,
         update_user,
         update_time,
         delete_flag)

VALUES (:userName,
        :password,
        :expiryDate,
        :deleteExpiredAccount,
        :mailAddress,
        :roleId,
        :registerUser,
        :registerTime,
        :updateUser,
        :updateTime,
        :deleteFlag);