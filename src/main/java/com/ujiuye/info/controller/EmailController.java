package com.ujiuye.info.controller;

import com.ujiuye.info.bean.Email;
import com.ujiuye.info.service.EmailService;
import com.ujiuye.jobs.EmailJob;
import com.ujiuye.sys.bean.Employee;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Email email, HttpSession session) throws Exception {
        Employee employee = (Employee)session.getAttribute("loginUser");

        //创建JobDetail对象，指定对象的任务名称、组名
        JobDetail job = JobBuilder.newJob(EmailJob.class).withIdentity("job1", "group1").build();

        job.getJobDataMap().put("email",email);
        job.getJobDataMap().put("javaMailSender",javaMailSender);
        //创建SimpleTrigger对象，指定对象名称、组名  设置任务重复执行间隔时间，重复执行次数 启动时间
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().
               /* withIdentity("trigger1", "group1").
                withSchedule(SimpleScheduleBuilder.*/
                       startAt(new Date()).build();
                        /*withIntervalInSeconds(10).//重复间隔
                        withRepeatCount(0)).//重复次数，一直重复的话设置repeatForever()*/

        //创建任务管理器Scheduler对象
        Scheduler sched= StdSchedulerFactory.getDefaultScheduler();
        //为Scheduler对象新增JOB以及对应的SimpleTrigger
        job.getJobDataMap().put("sched",sched);
        Date ft = sched.scheduleJob(job, trigger);
        //System.out.println("启动定时任务:"+ft.toLocaleString());
        //启动定时任务管理器
        sched.start();
      /*  //主线程睡眠2分钟
        try {
            // wait five minutes to show jobs
            Thread.sleep(120L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }*/
        email.setEmpFk(employee.getEid());
        emailService.saveInfo(email);

        return "redirect:/message.jsp";
    }

}
