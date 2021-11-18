package com.leyou.common.constants;

public interface CommonConstants {
	/**
	 * 是
	 */
	String YES = "1";
	/**
	 * 否
	 */
	String NO = "0";
	/**
	 * header 中租户ID
	 */
	String TENANT_ID = "tenant-id";
	/**
	 * header 中Authorization
	 */
	String AUTHORIZATION = "Authorization";
	/**
	 * upms数据库
	 */
	String UPMS_DATABASE = "sigma_upms";
	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";
	/**
	 * 日志类型：正常操作日志
	 */
	String LOG_TYPE_0 = "0";
	/**
	 * 日志类型：异常操作日志
	 */
	String LOG_TYPE_9 = "9";
	/**
	 * 菜单
	 */
	String MENU = "0";
	/**
	 * 按钮
	 */
	String BUTT = "1";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 邮箱
	 */
	String EMAIL = "email";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * 邮箱发送类型
	 */
	String EMAIL_SEND_TYPE_REGISTER = "register";

	/**
	 * 树形父类ID
	 */
	String PARENT_ID = "0";

	/**
	 * 数据权限类型
	 * 0全部，1自定义，2本级及子级，3本级
	 */
	Integer DS_TYPE_0 = 0;
	Integer DS_TYPE_1 = 1;
	Integer DS_TYPE_2 = 2;
	Integer DS_TYPE_3 = 3;

	/**
	 * 管理员角色编码
	 */
	String ROLE_CODE_ADMIN = "ROLE_ADMIN";
	/**
	 * 店员角色编码
	 */
	String ROLE_CODE_SHOP_USER = "ROLE_SHOP_USER";

	/**
	 * 文件类型：image：图片
	 */
	String FILE_TYPE_IMG = "image";

	String CONFIG_DATA_ID_DYNAMIC_ROUTES = "youai-gateway-router";
	String CONFIG_GROUP = "DEFAULT_GROUP";
	long CONFIG_TIMEOUT_MS = 5000;

}
