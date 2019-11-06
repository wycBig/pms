import com.alibaba.fastjson.JSON;
import com.ujiuye.ExcelUtils.ExcelRead;
import com.ujiuye.anal.bean.Goods;
import com.ujiuye.anal.service.BookServie;
import com.ujiuye.sys.bean.Employee;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AppTest {

    @Test
   /* public void test01(){
        //创建一个输入流，用来读取要录入的文件
       // String filePath = "C:\\Users\\Administrator\\Desktop\\excel.xlsx";
        //ExcelRead.getExcelContent(filePath);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BookServie bean = context.getBean(BookServie.class);
        List<Goods> list = bean.getList();
    }*/

   /* public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-quartz.xml");
    }*/
    public void test01() throws  Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("javaMail.xml");
        JavaMailSenderImpl bean = context.getBean(JavaMailSenderImpl.class);
        //邮件对象
        MimeMessage mailMessage = bean.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true,"UTF-8");
       helper.setFrom("18337662715@163.com");
        helper.setTo("w15600252753@163.com");
        helper.setSubject("这是主题");
        helper.setText("<html><head></head><body>来了，<span style='color:pink;'>老弟</span></body></html>",true);
        bean.send(mailMessage);
        System.out.println("发送成功");
    }
    @Test
    public void test02(){
        Employee employee = new Employee();
        employee.setEid(22);
        employee.setEname("wangwu");
        employee.setEage(33);

        Employee employee1 = new Employee();
        employee1.setEid(22);
        employee1.setEname("wangliu");
        employee1.setEage(33);

        Employee employee2 = new Employee();
        employee2.setEid(22);
        employee2.setEname("wangqi");
        employee2.setEage(33);

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee2);
        list.add(employee1);
        String s = JSON.toJSONString(list);
        List<Employee> employees = JSON.parseArray(s, Employee.class);
        System.out.println(employees);
    }
}
