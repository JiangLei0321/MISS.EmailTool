package com.ruubypay.mail.constants;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午6:55
 */
public enum MailCode {
    SUCCESS("0000","发送成功"),
    FAILURE("0001","发送失败"),
    ERROR("0002","发送异常");


    MailCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String msg;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
