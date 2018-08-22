SELECT count(*)
FROM tbl_user
WHERE user_name=:userName 
    AND pass_word=:password