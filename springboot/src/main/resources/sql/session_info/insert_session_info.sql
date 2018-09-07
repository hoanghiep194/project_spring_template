INSERT INTO session_info
        (customer_id,
         user_name,
         session_token,
         session_expired,
         regist_user,
         regist_time,
         update_user,
         update_time,
         delete_flag)
VALUES (:customerId,
        :userName,
        :sessionToken,
        :sessionExpired,
        :registUser,
        :registTime,
        :updateUser,
        :updateTime,
        :deleteFlag)