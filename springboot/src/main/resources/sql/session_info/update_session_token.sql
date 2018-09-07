UPDATE session_info
SET session_token = :token,
    session_expired = :expiredAt
WHERE user_name = :userName