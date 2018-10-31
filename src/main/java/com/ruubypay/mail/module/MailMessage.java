package com.ruubypay.mail.module;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij Idea
 * 入参
 * @author Jianglei
 * @date 2018/10/30 下午6:22
 */
public class MailMessage implements Serializable {
    //发件人昵称
    private String fromNick;
    //发给谁
    private String to;
    //邮件主题
    private String subject;
    //邮件内容
    private String text;
    //模板名称
    private String templateFileName;
    //模板参数
    private Map<String, String> templateParamMap;
    //附件
    private List<File> attachFiles;

    public MailMessage() {
    }

    public MailMessage(String fromNick, String to, String subject, String text, String templateFileName, Map<String, String> templateParamMap, List<File> attachFiles) {
        this.fromNick = fromNick;
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.templateFileName = templateFileName;
        this.templateParamMap = templateParamMap;
        this.attachFiles = attachFiles;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public Map<String, String> getTemplateParamMap() {
        return templateParamMap;
    }

    public void setTemplateParamMap(Map<String, String> templateParamMap) {
        this.templateParamMap = templateParamMap;
    }

    public List<File> getAttachFiles() {
        return attachFiles;
    }

    public void setAttachFiles(List<File> attachFiles) {
        this.attachFiles = attachFiles;
    }

    @Override
    public String toString() {
        return "MailMessage{" +
                "fromNick='" + fromNick + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", templateFileName='" + templateFileName + '\'' +
                ", templateParamMap=" + templateParamMap +
                ", attachFiles=" + attachFiles +
                '}';
    }
}
