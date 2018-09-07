SELECT se.user_name AS userName,
       se.session_token AS sessionToken,
       se.session_expired AS sessionExpired
FROM session_info se
WHERE se.session_token = :token