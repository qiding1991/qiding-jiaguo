package com.qiding.jiaguo.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

public class Md5Util {

    public  static  String md5Hex(String plainText){
        return DigestUtils.md5Hex(plainText);
    }

    public static String md5Hex(byte[] bytes){
        return DigestUtils.md5Hex(bytes);
    }


}
