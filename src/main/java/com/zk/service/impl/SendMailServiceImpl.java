package com.zk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class SendMailServiceImpl {

    //注入邮件工具类
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendMailer;

    private static final Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);

    public void sendHtmlMail(String sendTo, String subject, String text) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //邮件发件人
            helper.setFrom(sendMailer);
            //邮件收件人 1或多个
            helper.setTo(sendTo.split(","));
            //邮件主题
            helper.setSubject(subject);
            //邮件内容
            helper.setText(text, true);
            //邮件发送时间
            helper.setSentDate(new Date());
            javaMailSender.send(message);
            logger.info("发送邮件成功:{}->{}", sendMailer, sendTo);
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
    }


}

