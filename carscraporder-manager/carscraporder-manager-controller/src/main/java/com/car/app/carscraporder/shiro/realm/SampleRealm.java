package com.car.app.carscraporder.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.SystemException;
import com.car.app.carscraporder.exception.UserNamePasswordException;
import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.util.LoggerUtils;

/**
 * 
 * 类名称：SampleRealm   
 * 类描述：shiro的认证和授权类   
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:05:15      
 * @version  V1.0
 *
 */
public class SampleRealm  extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  PermissionService permissionService;
	
	
	
	public void clearAuthz(){
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}

	
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
	
		
		UserBO user = (UserBO) principals.getPrimaryPrincipal();
		
		//根据身份信息获取权限信息
		//从数据库获取到权限数据
	     List<Permission> permissionList = permissionService.getPermosssionsCodeByUserid(user.getId());
	     //查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		
		//单独定一个集合对象 
		List<String> permissions = new ArrayList<String>();
		if(permissionList!=null){
			for(Permission sysPermission:permissionList){
				//将数据库中的权限标签 符放入集合
				permissions.add(sysPermission.getPercode());
			}
		}
		
	   simpleAuthorizationInfo.addStringPermissions(permissions);
		 
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		
		 UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
	     String username = token.getUsername();
	     
	       
			try {
				UserBO user = userService.queryUserBOByName(username);
				
				if(user!=null){
					 // 第一个参数也可以放user对象，这样在doGetAuthorizationInfo()方法中可以直接使用
			        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getPasswordSalt()),getName());
				}else{
					throw new UserNamePasswordException("用户名密码错误");
				}
				
			} catch (Exception e) {
				
				LoggerUtils.error(SampleRealm.class, "shiro认证根据用户名查询是否存在用户错误，错误原因："+e.toString());
				throw new SystemException("系统异常");
			}
			
	     
	        
	       
	        
	       
	}
	
	
	
}
