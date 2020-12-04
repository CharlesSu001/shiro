/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: User
 * Author:   苏晨宇
 * Date:     2020/12/4 13:17
 * Description: 用户类 存放账户和密码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户类 存放账户和密码〉
 *
 * @author 苏晨宇
 * @create 2020/12/4
 * @since 1.0.0
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
 
