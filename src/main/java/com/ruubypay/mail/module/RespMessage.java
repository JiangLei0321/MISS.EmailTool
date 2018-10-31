package com.ruubypay.mail.module;

import java.io.Serializable;

/**
 * Created by Intellij Idea
 * 出参
 * @author Jianglei
 * @date 2018/10/30 下午6:52
 */
public class RespMessage implements Serializable {
    private String respCode;
    private String respMsg;

    public RespMessage() {
    }

    public RespMessage(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    @Override
    public String toString() {
        return "RespMessage{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                '}';
    }
}
