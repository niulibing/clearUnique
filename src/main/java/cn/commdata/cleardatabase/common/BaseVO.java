package cn.commdata.cleardatabase.common;

import lombok.Data;

/**
 * @author libing.niu
 * @version 1.0
 * @classname: BaseVO
 * @since 2019/12/18 10:02
 */

/**
 * 公共类
 * @param <T>
 */
@Data
public class BaseVO<T> {
    /**
     * success返回值
     */
    public static final int SUCCESS_CODE = 10000;
    /**
     * 未登录
     */
    public static final int UNLOGIN_CODE = 20000;
    /**
     * 无权限
     */
    public static final int UNAUTHORIZED_CODE = 20001;
    /**
     * 用户名密码错误
     */
    public static final int AUTHENTICATION_FAIL_CODE = 20003;
    /**
     * 资源冲突
     */
    public static final int CONFLICT_CODE = 20004;
    /**
     * 参数不合法
     */
    public static final int ILLEGAL_PARAM_CODE = 20005;
    /**
     * 其他返回值
     */
    public static final int OTHER_CODE = 30000;
    /**
     * 取消成功
     */
    public static final int CANCEL_CODE = 30001;
    /**
     * 默认返回消息
     */
    private static final String SUCCESS_MSG = "操作成功";

    /**
     * 返回值
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 无参构造
     * @param queueId
     */
    public BaseVO(Long queueId) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    /**
     * 构造函数
     * @param msg 返回内容
     */
    public BaseVO(String msg) {
        this.code = SUCCESS_CODE;
        this.msg = msg;
    }

    /**
     * 构造函数
     * @param msg 返回内容
     * @param data 数据
     */
    public BaseVO(String msg, T data) {
        this.code = SUCCESS_CODE;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     * @param code 返回值
     * @param msg 返回内容
     * @param data 数据
     */
    public BaseVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数
     * @param code 返回值
     * @param msg 消息
     */
    public BaseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
