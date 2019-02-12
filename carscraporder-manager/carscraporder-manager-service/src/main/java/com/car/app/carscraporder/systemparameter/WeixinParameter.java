package com.car.app.carscraporder.systemparameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 
 * 类名称：WeixinParameter   
 * 类描述：   微信相关的参数配置类
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:07:54      
 * @version  V1.0
 *
 */
@Service
public class WeixinParameter {
	
       @Value("${COREID}")
	   public  String coreid;
       
       @Value("${SECRET}")
       public  String secret;
       
       
       
     
		
		
       
	  
	   
	   /**
	    * 企业微信获取人员详情
	    * https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}
	    */
	   @Value("${GET_USERINFO_URL}")
	   public  String getWeixinUserInfoURL;
	   
	   /**
	    * 企业微信鉴权链接
	    * https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={3}&state=STATE#wechat_redirect
	    */
	   @Value("${WEIXIN_AUTHORIZE}")
	   public  String getWeixinAuthorizeURL;
	   
	   /**
	    * 鉴权需要的ACCESSTOKEN区别普通的accesstoken (获取用户的openid)
	    * https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code
	    */
	   @Value("${WEIXIN_AUTHORIZE_ACCESSTOKEN}")
	   public  String getWeixinAuthorizeAccesstokenURL;
	   
	   /**
	    * 获取微信用户的基本信息
	    * GET_USERINFO_URL=https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid={1}
	    */
	   @Value("${GET_USERINFO_URL}")
	   public  String getUserInfoURL;
	   
	   
	     
	   /**
	    * 鉴权回调URI
	    * http%3A%2F%2F1989l1990.iask.in%2Fuser%2Foauth2%2Fauthorize
	    */
	   @Value("${REDIRECT_URI}")
	   public  String redirectURL;
	   
	   /**
	    * token在缓存中的有效时间
	    */
	   @Value("${TOKEN_EXPIRE}")
	   public Integer tokenExpire;




		
}
