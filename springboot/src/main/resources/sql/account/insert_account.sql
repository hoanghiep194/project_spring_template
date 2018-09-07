INSERT INTO account
        (customer_id,
         user_name,
         password,
         expiry_date,
         delete_expired_account,
         role_id,
         register_user,
         register_time,
         update_user,
         update_time,
         delete_flag)

VALUES (:customerId,
        :userName,
        :password,
        :expiryDate,
        :deleteExpiredAccount,
        :roleId,
        :registerUser,
        :registerTime,
        :updateUser,
        :updateTime,
        :deleteFlag);