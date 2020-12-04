/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TestEncryption
 * Author:   苏晨宇
 * Date:     2020/12/4 14:50
 * Description: md5加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 〈一句话功能简述〉<br> 
 * 〈md5加密〉
 *
 * @author 苏晨宇
 * @create 2020/12/4
 * @since 1.0.0
 */
public class TestEncryption {
    public static void main(String[] args){
        String password="123";
//        String encodedPassword=new Md5Hash(password).toString();
//        System.out.println(encodedPassword);
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        int times=2;
        String algorithmName="md5";
        String encodedPassword=new SimpleHash(algorithmName,password,salt,times).toString();
        System.out.format("原始密码是:%s\t盐是:%s\t运算次数是:%d\t密文是:%s\t",password,salt,times,encodedPassword);
    }
}
 
