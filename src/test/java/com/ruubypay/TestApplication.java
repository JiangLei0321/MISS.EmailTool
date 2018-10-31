package com.ruubypay;

import com.ruubypay.mail.module.MailMessage;
import com.ruubypay.mail.module.RespMessage;
import com.ruubypay.mail.service.IMailSendService;
import com.ruubypay.mail.util.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/10/30 下午4:45
 */
public class TestApplication {
    public static void main( String[] args ) {
        ApplicationContext ctx = new  ClassPathXmlApplicationContext("applicationContext.xml");
        IMailSendService mailsendService=(IMailSendService) ctx.getBean("templateMailService");
        MailMessage mailMessage = new MailMessage();
        mailMessage.setFromNick("易通行");
        mailMessage.setTo("jianglei_bean@163.com");
        mailMessage.setSubject("易通行电子发票及行程报销单");
        mailMessage.setText("挖的天哪，哈哈哈！");
        mailMessage.setTemplateFileName("simple.ftl");
        Map<String,String> params = new HashMap<String, String>();
        params.put("title","易通行电子邮件");
        params.put("call","尊敬的易通行乘客：");
        params.put("content","感谢您使用易通行APP为您提供的出行乘车服务。您于"+DateUtil.getNowDateTime()+"申请的电子发票已发出，您可登录您的邮箱，或者前往“个人中心-开具发票-开票历史页”查看发票信息，点击以下链接，也可下载电子发票图片，感谢您的使用。");
        params.put("pdfUrl","http://digi.aisino.com/FPFX/actions/740e74773eb3821d519e77a860c687ab9e1151");
        params.put("footer","易通行为您服务");
        mailMessage.setTemplateParamMap(params);
        File file = new File("/Users/ruubypay/Documents/invoice.pdf");
        List<File> fileList = new ArrayList<File>();
        fileList.add(file);
        mailMessage.setAttachFiles(fileList);
        RespMessage respMessage = mailsendService.sendMessage(mailMessage);
        System.out.println(respMessage.toString());
    }
}