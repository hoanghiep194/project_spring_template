package jp.co.run.api.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * The Enum PropertiesFile.
 */
public enum PropertiesFile {

    /** The message. */
    MESSAGE("message.properties"),

    /** The setting. */
    SETTING("setting.properties");

    /** The properties. */
    private Properties properties;

    /**
     * Instantiates a new properties file.
     *
     * @param fileName
     *            the file name
     */
    private PropertiesFile(String fileName) {
        load(fileName);
    }

    /**
     * Load.
     *
     * @param fileName
     *            the file name
     */
    private void load(String fileName) {
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            is = new BufferedInputStream(loader.getResourceAsStream("properties/" + fileName));
            isr = new InputStreamReader(is, Constants.CONST_ENCODE);

            this.properties = new Properties();
            properties.load(isr);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * Gets the.
     *
     * @param key
     *            the key
     * @return the string
     */
    public String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Gets the integer.
     *
     * @param key
     *            the key
     * @return the integer
     */
    public Integer getInteger(String key) {
        return Integer.valueOf(properties.getProperty(key));
    }
}
