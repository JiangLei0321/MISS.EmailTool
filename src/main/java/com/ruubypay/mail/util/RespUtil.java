package com.ruubypay.mail.util;

import com.ruubypay.mail.constants.MailCode;
import com.ruubypay.mail.module.RespMessage;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午6:59
 */
public class RespUtil {
    public static RespMessage getResult(MailCode mailCode) {
        RespMessage respMessage = new RespMessage();
        respMessage.setRespCode(mailCode.getCode());
        respMessage.setRespMsg(mailCode.getMsg());
        return respMessage;
    }
}
