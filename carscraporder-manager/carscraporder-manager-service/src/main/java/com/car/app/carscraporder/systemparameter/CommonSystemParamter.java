package com.car.app.carscraporder.systemparameter;

public class CommonSystemParamter {
	
	/**
	 * 1.未接单(提交订单)
	 */
	public static final Integer ORDER_CREATE_STATUS=1;
	/**
	 * 2.接单派单
	 */
	public static final Integer ORDER_DISTRIBUTION_STATUS=2;
	/**
	 * 3.业务员接收车辆
	 */
	public static final Integer ORDER_RECEIVE_STATUS=3;
	/**
	 * 4.入场
	 */
	public static final Integer ORDER_STORAGE_STATUS=4;
	/**
	 * 5.报废(出库)
	 */
	public static final Integer ORDER_SCRAP_STATUS=5;
	
	/**
	 * 6.财务结算
	 */
	public static final Integer ORDER_SETTLEMENT_STATUS=6;
	
	/**
	 * 7.订单结束
	 */
	public static final Integer ORDER_END_STATUS=7;
	
	/**
	 * 8.订单异常
	 */
	public static final Integer ORDER_ERROR_STATUS=8;
	

	
	/**
	 * 1.配件初始状态
	 */
	public static final Integer PARTS_CREATE_STATUS=1;
	/**
	 * 2.配件接单
	 */
	public static final Integer PARTS_RECEIPT_STATUS=2;
	/**
	 * 3.配件接收
	 */
	public static final Integer PARTS_RECEIVE_STATUS=3;
	
	/**
	 * 4.配件无法接收
	 */
	public static final Integer PARTS_NO_RECEIVE_STATUS=4;
	
	
	/**
	 * 5.配件入库
	 */
	public static final Integer PARTS_STORAGE_STATUS=5;
	
	
	/**
	 * 6.配件出库
	 */
	public static final Integer PARTS_OUT_STORAGE_STATUS=6;
	/**
	 * 7.配件残值发放
	 */
	public static final Integer PARTS_SETTLEMENT_STATUS=7;
	/**
	 * 8.配件结束
	 */
	public static final Integer PARTS_END_STATUS=8;
	/**
	 * 9.配件异常
	 */
	public static final Integer PARTS_ERROR_STATUS=9;
	
	
	/**
	 * 各人客户
	 */
	public static final String CLIENT_ORDINARY_TYPE="1";
	/**
	 * 大客户类型
	 */
	public static final String CLIENT_VIP_TYPE="2";
	/**
	 * 整车订单
	 */
	public static final String ORDER_WhOLECAR_TYPE="1";
	
	/**
	 * 旧件订单
	 */
	public static final String ORDER_OLDPARTS_TYPE="2";
	
	/**
	 * 用户状态 ：正常
	 */
	public static final String USER_STATUS_NORMAL="1";
	/**
	 * 用户状态 ：删除
	 */
	public static final String USER_STATUS_DELETE="2";
	/**
	 * 用户状态:禁用
	 */
	public static final String USER_STATUS_DISABLE="3";
	/**
	 * 密码hash次数
	 */
	public static final int HASHITERATIONS =2;
	
	/**
	 * 整车订单业务
	 */
	public static final String BUSINESS_TYPE_ORDER="1";
	/**
	 * 配件业务
	 */
	public static final String BUSINESS_TYPE_AUTOPARTS="2";
	
	/**
	 * 车辆照片
	 */
	public static final String ORDER_PICTURE_CAR="1";
	/**
	 * 车辆手续照片
	 */
	public static final String ORDER_PICTURE_CAR_FORMALITIES="2";
	/**
	 *车辆毁型照片
	 */
	public static final String ORDER_PICTURE_CAR_DESTROY="3";
	/**
	 *车辆报废证明照片
	 */
	public static final String ORDER_PICTURE_CAR_CERTIFICATE="4";
	/**
	 * 配件照片
	 */
	public static final String PARTS_PICTURE="1";
	/**
	 * 配件接收照片
	 */
	public static final String PARTS_PICTURE_RECEIVE="2";
	/**
	 * 配件入库照片
	 */
	public static final String PARTS_PICTURE_WAREHIUSING="3";
	
	/**
	 * 配件入库照片
	 */
	public static final String PARTS_SCARP_RECEIVE="4";
	
	public static final String PARTS_VIDEO="10";
	

}
