package com.ruubypay.mail.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import com.ruubypay.mail.constants.MailCode;
import com.ruubypay.mail.module.MailMessage;
import com.ruubypay.mail.module.RespMessage;
import com.ruubypay.mail.service.IMailSendService;
import com.ruubypay.mail.util.RespUtil;
import freemarker.template.TemplateException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.StringUtils;

/**
 * Created by Intellij Idea
 * 带模板带附件的邮件
 * @author Jianglei
 * @date 2018/10/30 下午5:19
 */
public class TemplateMailServiceImpl implements IMailSendService {

    private JavaMailSender mailSender;
    private Properties mailConfig;
    private Configuration configuration;

    /**
     * 邮件发送
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
            helper.setText(getText(configuration, mailMessage),true);
            if(mailMessage.getAttachFiles() != null && mailMessage.getAttachFiles().size()>0) {
                for (File attachFile : mailMessage.getAttachFiles()) {
                    helper.addAttachment(attachFile.getName(),attachFile);
                }
            }
            //从模板里面读取
            mailSender.send(message);
            mailCode = MailCode.SUCCESS;
        } catch (Exception e) {
            mailCode = MailCode.ERROR;
            // TODO 异常执行块！
            e.printStackTrace();
        }
        return RespUtil.getResult(mailCode);
    }

    /**
     * 读取freemarker模板的方法
     */
    private String getText(Configuration freeMarkerConfiguration, MailMessage mailMessage) throws IOException,TemplateException{
        if(StringUtils.isEmpty(mailMessage.getTemplateFileName())) {
            throw new NullPointerException("Template is Null");
        }
        Template template = freeMarkerConfiguration.getTemplate(mailMessage.getTemplateFileName());
        //解析模板文件
        String templateContext = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailMessage.getTemplateParamMap());
        System.out.println(templateContext);
        return templateContext;
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

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}