package com.ujiuye.jobs;

import com.ujiuye.info.bean.Email;
import org.quartz.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时发送邮件");
        //关闭定时任务管理器
        /*sched.shutdown(true);*/
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        Email email = (Email)dataMap.get("email");
        Scheduler sched = (Scheduler)dataMap.get("sched");
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl)dataMap.get("javaMailSender");


        //邮件对象
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mailMessage,true,"UTF-8");
            helper.setFrom("18337662715@163.com");
            helper.setTo(email.getEname());
            helper.setSubject(email.getTitle());
            helper.setText(email.getContent(),true);
            javaMailSender.send(mailMessage);
            System.out.println("发送成功");
            sched.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
