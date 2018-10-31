package com.ruubypay.mail.service;

import com.ruubypay.mail.module.MailMessage;
import com.ruubypay.mail.module.RespMessage;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午5:16
 */

public interface IMailSendService {

    /**
     *
     * @Title: sendMessage
     * @Description: 该方法的主要作用：发送邮件
     * @param   设定文件
     * @return  返回类型：void
     * @throws
     */
    public RespMessage sendMessage(MailMessage mailMessage);
}