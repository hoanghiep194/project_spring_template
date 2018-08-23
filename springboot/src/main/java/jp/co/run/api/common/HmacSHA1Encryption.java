package jp.co.run.api.common;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * The Class Md5Encryption.
 */
public class HmacSHA1Encryption {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String TRANSFORMATION_PADDING = "SHA1PRNG";
    /**
     * Generate storng password hash.
     *
     * @param password the password
     * @return the string
     * @throws Exception the exception
     */
    public static String generateStorngPasswordHash(String password) throws Exception {

        Random ran = new Random();
        int iterations = ran.nextInt(1000) + 1;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    /**
     * Validate password.
     *
     * @param originalPassword the original password
     * @param storedPassword the stored password
     * @return true, if successful
     * @throws Exception the exception
     */
    public static boolean validatePassword(String originalPassword, String storedPassword) throws Exception {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    /**
     * Gets the salt.
     *
     * @return the salt
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(TRANSFORMATION_PADDING);
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    /**
     * To hex.
     *
     * @param array the array
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    /**
     * From hex.
     *
     * @param hex the hex
     * @return the byte[]
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
