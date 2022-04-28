package com.fc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class MailTest {
    //java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testHtmlMail(){
        //创建一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件的发送人
        message.setFrom("2998701715@qq.com");
        //设置邮件的接收人
        message.setTo("2904937506@qq.com",
                "813818443@qq.com",
                "3335939034@qq.com",
                "1977331678@qq.com",
                "412790423@qq.com");
        //设置邮件主题
        message.setSubject("永久冻结通知");
        //设置邮件内容
        message.setText("你好，你的账号检测到有违法操作，您的账号将在24h之后被永久冻结，请将账户相关资金尽快转移，避免造成您的困扰！");
        //设置抄送
        message.setCc("635702657@qq.com");
        //秘密抄送
        message.setBcc("2937753364@qq.com");

        sender.send(message);
    }
}
