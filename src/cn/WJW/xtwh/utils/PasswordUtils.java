package cn.WJW.xtwh.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by WJW on 2019/3/28.
 */
public class PasswordUtils {

    public static String md5(String password, String salt){

        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String str = encoder.encodePassword(password.toLowerCase(), salt.toLowerCase());
        return str;
    }

    public static void main(String[] args){
        String pwd = PasswordUtils.md5("4321","WJW");
        System.err.println(pwd);

        pwd = PasswordUtils.md5("1111","jack");
        System.err.println(pwd);

        pwd = PasswordUtils.md5("1234","李华");
        System.err.println(pwd);

    }
}
