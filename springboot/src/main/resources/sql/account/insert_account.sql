INSERT INTO account
        (user_name,
         expiry_date,
         delete_expired_account,
         role_id,
         register_user,
         register_time,
         update_user,
         update_time,
         delete_flag)

VALUES (:userName,
        :expiryDate,
        :deleteExpiredAccount,
        :roleId,
        :registerUser,
        :registerTime,
        :updateUser,
        :updateTime,
        :deleteFlag);