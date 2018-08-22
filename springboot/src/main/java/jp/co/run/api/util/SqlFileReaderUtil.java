package jp.co.run.api.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import jp.co.run.api.common.Constants;

/**
 * The Class SqlFileReaderUtil.
 */
public final class SqlFileReaderUtil {

    /** The sql map. */
    private static ConcurrentHashMap<String, String> sqlMap = new ConcurrentHashMap<String, String>();

    /** The Constant SQL_FILE_BASE_PATH. */
    private static final String SQL_FILE_BASE_PATH = "sql";

    /** The read byte. */
    private static int readByte = Constants.CONST_READ_BYTE;

    /** The bom. */
    private static char bom = Constants.CONST_BOM;

    /**
     * Instantiates a new sql file reader util.
     */
    private SqlFileReaderUtil() {
    }

    /**
     * Gets the sql.
     *
     * @param path
     *            the path
     * @return the sql
     * @throws Exception
     *             the exception
     */
    public static String getSql(String path)
            throws Exception
    {
        if (!path.endsWith(Constants.CONST_TYPE_SQL)) {
            path = path + Constants.CONST_TYPE_SQL;
        }
        String sql = null;
        sql = (String) sqlMap.get(path);
        if (!StringUtils.isEmpty(sql)) {
            return sql;
        }
        sql = readSqlFile(SQL_FILE_BASE_PATH + path);
        if (!StringUtils.isEmpty(sql)) {
            String current = (String) sqlMap.putIfAbsent(path, sql);
            return current != null ? current : sql;
        }
        throw new IOException(path + ":failed to fetch Sql from this file.");
    }

    /**
     * Read sql file.
     *
     * @param path
     *            the path
     * @return the string
     * @throws Exception
     *             the exception
     */
    private static String readSqlFile(String path) throws Exception {
        ClassLoader loader = SqlFileReaderUtil.class.getClassLoader();
        InputStream is = null;
        Reader reader = null;
        BufferedReader br = null;
        String sql = Constants.CONST_STRING_EMPTY;
        try {
            StringBuilder sb = new StringBuilder(readByte);
            is = loader.getResourceAsStream(path);
            if (is != null) {
                reader = new InputStreamReader(is, Constants.CONST_ENCODE);
                br = new BufferedReader(reader);
                char[] buf = new char[readByte];
                int n;
                while ((n = br.read(buf)) >= 0) {
                    sb.append(buf, 0, n);
                }
                sql = sb.toString();
            }
        } finally {
            closeStream(br);
            closeStream(reader);
            closeStream(is);
        }

        if ((sql.length() > 0) && (sql.charAt(0) == bom)) {
            sql = sql.substring(1);
        }

        return sql;
    }

    /**
     * Close stream.
     *
     * @param cl            the cl
     * @throws Exception the exception
     */
    private static void closeStream(Closeable cl) throws Exception {
        if (cl != null) {
            cl.close();
        }
    }
}
