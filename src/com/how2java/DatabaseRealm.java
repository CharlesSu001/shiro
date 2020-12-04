/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DatabaseRealm
 * Author:   苏晨宇
 * Date:     2020/12/4 14:30
 * Description: 通过数据库验证用户并授权
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.how2java;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈通过数据库验证用户并授权〉
 *
 * @author 苏晨宇
 * @create 2020/12/4
 * @since 1.0.0
 */
public class DatabaseRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //进入这里 表明账号通过验证
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //通过DAO获取角色和权限
        Set<String> permissions = new DAO().listPermissions(userName);
        Set<String> roles = new DAO().listRoles(userName);

        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过DAO获取的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(roles);
        return s;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) authenticationToken;
        String userName = authenticationToken.getPrincipal().toString();
        String password = new String(t.getPassword());

        //获取数据库中的密码


        //String passowordInDB = new DAO().getPassword(userName);
        User user = new DAO().getUser(userName);
        String passowordInDB = user.getPassword();
        String salt = user.getSalt();

        //String passwordEncoded=new SimpleHash("md5",password,salt,2).toString();

//        if (user == null || !passowordInDB.equals(passwordEncoded))
//            throw new AuthenticationException();
        //配置HashedCredentialsMatcher进行自动校验
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName, passowordInDB, ByteSource.Util.bytes(salt), getName());
        return a;
    }
}
 
