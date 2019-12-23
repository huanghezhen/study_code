package hhz.common.entity;

/**
 * @ClassName: ResultCode
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 14:21
 */
public enum ResultEnum {

    SUCCESS(true,null,"操作成功"),

    FAIL(false,null,"操作失败"),

    NEED_LOGIN(false,null,"您还未登录"),
    LOGIN_ERROR(false,null,"账户或密码错误"),
    PERMISSION_DENIED(false,null,"权限不足"),

    ;

    //操作是否成功
    boolean state;
    //操作代码
    Integer code;
    //提示信息
    String message;

    ResultEnum(boolean state,Integer code, String message){
        this.state = state;
        this.code = code;
        this.message = message;
    }

    public boolean state() {
        return state;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
