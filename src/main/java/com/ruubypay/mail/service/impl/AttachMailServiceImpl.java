package com.ruubypay.mail.service.impl;

import com.ruubypay.mail.constants.MailCode;
import com.ruubypay.mail.module.MailMessage;
import com.ruubypay.mail.module.RespMessage;
import com.ruubypay.mail.service.IMailSendService;
import com.ruubypay.mail.util.RespUtil;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.Properties;

/**
 * Created by Intellij Idea
 * 带附件的邮件
 * @author Jianglei
 * @date 2018/10/30 下午5:21
 */
public class AttachMailServiceImpl implements IMailSendService {

    private JavaMailSender mailSender;
    private Properties mailConfig;

    /**
     * 发送邮件
     * @param mailMessage
     */
    public RespMessage sendMessage(MailMessage mailMessage) {
        MailCode mailCode = MailCode.FAILURE;
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message,true,"utf-8");
            String fromNick = MimeUtility.encodeText(mailMessage.getFromNick());
            helper.setFrom(fromNick+"<"+mailConfig.getProperty("mail.userName")+">");
            helper.setTo(mailMessage.getTo());
            helper.setSubject(mailMessage.getSubject());
            helper.setText(mailMessage.getText());
            if(mailMessage.getAttachFiles() != null && mailMessage.getAttachFiles().size()>0) {
                for (File attachFile : mailMessage.getAttachFiles()) {
                    helper.addAttachment(attachFile.getName(),attachFile);
                }
            }
            //添加附件,测试无误
            /*File file = new File("/Users/ruubypay/Documents/invoice.pdf");
            helper.addAttachment(file.getName(),file);*/
            mailSender.send(message);
            mailCode = MailCode.SUCCESS;
        } catch (Exception e) {
            mailCode = MailCode.ERROR;
            // TODO 异常执行块！
            e.printStackTrace();
        }
        return RespUtil.getResult(mailCode);
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public Properties getMailConfig() {
        return mailConfig;
    }

    public void setMailConfig(Properties mailConfig) {
        this.mailConfig = mailConfig;
    }
}