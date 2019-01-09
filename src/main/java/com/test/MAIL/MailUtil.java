package com.test.MAIL;


import com.google.common.base.Charsets;
import org.apache.commons.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by xiaojie.Ma on 2018/12/28.
 */
@Component
public class MailUtil {

    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);


    private static String EMAIL_HOSTNAME;

    private static String EMAIL_ACCOUNT;

    private static String EMAIL_PASSWORD;

    private static String EMAIL_FROM_ADDRESS;

    private static String EMAIL_SENDER;

    private static String EMAIL_SSLPORT;

    @Value("${mail.hostName}")
    public  void setEmailHostname(String emailHostname) {
        EMAIL_HOSTNAME = emailHostname;
    }
    @Value("${mail.account}")
    public  void setEmailAccount(String emailAccount) {
        EMAIL_ACCOUNT = emailAccount;
    }
    @Value("${mail.password}")
    public  void setEmailPassword(String emailPassword) {
        EMAIL_PASSWORD = emailPassword;
    }
    @Value("${mail.address}")
    public  void setEmailFromAddress(String emailFromAddress) {
        EMAIL_FROM_ADDRESS = emailFromAddress;
    }
    @Value("${mail.sender}")
    public  void setEmailSender(String emailSender) {
        EMAIL_SENDER = emailSender;
    }
    @Value("${mail.sslPort}")
    public  void setEmailSslport(String emailSslport) {
        EMAIL_SSLPORT = emailSslport;
    }

    /**
     * 发送简单邮件，类似一条信息
     * @param toAddress
     * @param toName
     * @param subject
     * @param msg
     * @throws Exception
     */
    public static void sendSimpleEmail(String toAddress, String toName, String subject, String msg) throws Exception {
        SimpleEmail email = MailUtil.newSimpleEmail();
        // 设置收件人信息
        email.addTo(toAddress, toName, Charsets.UTF_8.name());
        // 设置主题
        email.setSubject(subject);
        // 设置邮件内容
        email.setMsg(msg);
        // 发送邮件
        email.send();
    }

    /**
     * 发送Html内容的邮件
     * @param toAddress
     * @param toName
     * @param subject
     * @param htmlMsg
     * @throws Exception
     */
    public static void sendHtmlEmail(String toAddress, String toName, String subject, String htmlMsg) throws Exception {
        HtmlEmail email = MailUtil.newHtmlEmail();
        email.addTo(toAddress, toName, Charsets.UTF_8.name());
        email.setSubject(subject);

        // 设置html内容，实际使用时可以从文本读入写好的html代码
        email.setHtmlMsg(htmlMsg);
        email.send();
    }

    /**
     * 发送复杂的邮件，包含附件等
     * @param toAddress
     * @param toName
     * @param subject
     * @param msg
     * @param attachment
     * @throws Exception
     */
    public static void sendMultiPartEmail(String toAddress, String toName, String subject, String msg,
                                          EmailAttachment attachment) throws Exception {
        MultiPartEmail email = MailUtil.newMultiPartEmail();
        email.addTo(toAddress, toName, Charsets.UTF_8.name());
        email.setSubject(subject);
        email.setMsg(msg);
        email.attach(attachment);
        email.send();
    }

    public static SimpleEmail newSimpleEmail() {
        SimpleEmail email = new SimpleEmail();
        MailUtil.setDefault(email);
        return email;
    }

    public static MultiPartEmail newMultiPartEmail() {
        MultiPartEmail email = new MultiPartEmail();
        MailUtil.setDefault(email);
        return email;
    }

    public static HtmlEmail newHtmlEmail() {
        HtmlEmail email = new HtmlEmail();
        MailUtil.setDefault(email);
        return email;
    }

    /**
     * 设置系统默认使用的发件人信息
     * @param email
     */
    private static void setDefault(Email email) {
        email.setHostName(EMAIL_HOSTNAME);
        email.setAuthentication(EMAIL_ACCOUNT, EMAIL_PASSWORD);
        email.setCharset(Charsets.UTF_8.name());
        email.setSSLOnConnect(true);
        email.setSslSmtpPort(EMAIL_SSLPORT);
        try {
            email.setFrom(EMAIL_FROM_ADDRESS, EMAIL_SENDER, Charsets.UTF_8.name());
        } catch (EmailException e) {
            logger.error("设置发送账户异常:{}", e);
        }
    }

}
