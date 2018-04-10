package com.common.util.string;

import java.security.MessageDigest;

/**
 * Created by LiNan on 2018-04-09.
 * Description: MD5加Salt加密用户密码
 */
public class Md5SaltUtil {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    private Object salt;
    private String algorithm;

    public Md5SaltUtil(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }
    public String encode(String rawPass) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            // 加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes("utf-8")));
        } catch (Exception ex) {
        }
        return result;
    }

    public boolean isPasswordValid(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);
        return pass1.equals(pass2);
    }

    private String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        String salt = StringUtil.createRandomCode(5);
        Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");

        String testWithMD5 = encoderMd5.encode("test");
        System.out.println(testWithMD5);

        boolean passwordValid = encoderMd5.isPasswordValid(testWithMD5, "test");
        System.out.println(passwordValid);

		Md5SaltUtil encoderSha = new Md5SaltUtil(salt, "SHA");
		String testWithSHA = encoderSha.encode("test");
		System.out.println(testWithSHA);
		boolean passwordValid2 = encoderSha.isPasswordValid(testWithSHA, "test");
		System.out.println(passwordValid2);
    }
}
