package com.ujiuye.cus.controller;

import com.ujiuye.ExcelUtils.ExcelRead;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.Param;
import com.ujiuye.cus.service.CustomerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cus")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //异步获取到公司名称
    @RequestMapping(value = "/getComName" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getComName(){
        return customerService.getAllCustomer();
    }
    //异步获取到指定公司的负责人
    @RequestMapping(value = "/getComPerson/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Customer getComPerson(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }
    //添加客户信息
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insertCustomer(Customer customer){
        boolean isSuccess = customerService.insertCustomer(customer);
        if (isSuccess){
            return "redirect:/cus/list";
        }
        return "redirect:/customer-add.jsp";
    }
    //查询所有的客户信息
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllCustomer(){
        ModelAndView mv = new ModelAndView("customer");
        List<Customer> customers = customerService.getAllCustomer();
        mv.addObject("mv",customers);
        return mv;
    }
    //查询某个客户信息
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String getCustomer(@PathVariable("id") Integer id,Map<String,Customer> map){
        Customer customer = customerService.getCustomer(id);
        map.put("cust",customer);
        return "customer-edit" ;
    }
    //通过id修改某条信息
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public String updateCustomer(@PathVariable("id") Integer id,Customer customer){
        customer.setId(id);
        boolean isSuccess = customerService.updateCustomer(customer);
        if (isSuccess){
            return "redirect:/cus/list";
        }
        return "redirect:/customer-add.jsp";
    }
    //查询某个客户信息
    @RequestMapping(value = "/getTwo/{id}",method = RequestMethod.GET)
    public String getCustomerTwo(@PathVariable("id") Integer id,Map<String,Customer> map){
        Customer customer = customerService.getCustomer(id);
        map.put("cust",customer);
        return "customer-look" ;
    }
    //删除一些用户信息
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCustomers(@PathVariable("id") String id,Map<String,Object> map){
        System.out.println(id);
        boolean isSuccess = customerService.deleteCustomers(id);
        if (isSuccess){
            map.put("msg",200);
        }
        return "redirect:/cus/list";
    }
    //根据条件查询数据
    @RequestMapping(value = "/selectCondition",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCustomerCondition(Param param){
        ModelAndView mv = new ModelAndView("customer");
        System.out.println(param);
        List<Customer> customers = customerService.getCustomerCondition(param);
        mv.addObject("mv",customers);
        return mv;
    }
    //导出excel
    @RequestMapping(value = "/upEx",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> upFile(){
        Map<String,Object> map = new HashMap<String, Object>();
        //创建一个excel
        Workbook wb = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = wb.createSheet("表单一");
        //创建一个标题属性行
        Row row1 = sheet.createRow(0);
        Cell[] cells = new HSSFCell[5];
        for (int i = 0;i < 5;i++){
           cells[i] = row1.createCell(i);
        }
        //创建属性行的数属性列
        cells[0].setCellValue("ID");
        cells[1].setCellValue("联系人");
        cells[2].setCellValue("公司名称");
        cells[3].setCellValue("添加时间");
        cells[4].setCellValue("联系电话");
        //获取到所有的customer
        List<Customer> allCustomer = customerService.getAllCustomer();
        //遍历集合
        for (int i = 0; i < allCustomer.size(); i++) {
            //获取一个文件对象
            Customer customer = allCustomer.get(i);
            //创建一行
            Row row = sheet.createRow( 1+i);
            Cell[] cellss = new HSSFCell[5];
            //创建一列
            for (int j = 0;j < 5;j++){
                cellss[j] = row.createCell(j);
            }
            //为这一行添加数据
            cellss[0].setCellValue(i+1);
            cellss[1].setCellValue(customer.getCompanyperson());
            cellss[2].setCellValue(customer.getComname());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date addtime = customer.getAddtime();
            String format = sdf.format(addtime);
            cellss[3].setCellValue(format);
            cellss[4].setCellValue(customer.getComphone());
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\excel.xlsx"));
            //将创建的excel利用输出流输出到给定的位置
            wb.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
               if (fos != null){
                   fos.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("statuCode",200);
        map.put("msg","下载成功");
        return map;
    }
    //上传excel
    @RequestMapping(value = "/fileUp",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> excelGain(MultipartFile excel){
        Map<String,Object> map= null;
        //定义一个对象来存储获得到的对象
        List<Customer> customers = new ArrayList<Customer>();
        try {
            InputStream inputStream = excel.getInputStream();
            Workbook wb = WorkbookFactory.create(inputStream);
            //获取到表单个数
            int numberOfSheets = wb.getNumberOfSheets();
            //遍历得到所有的表单
            for(int i = 0;i<numberOfSheets;i++){
                //获取到一个sheet对象
                Sheet sheetAt = wb.getSheetAt(i);
                //获取到第一行，最后一行
                int firstRowNum = sheetAt.getFirstRowNum();
                int lastRowNum = sheetAt.getLastRowNum();
                //遍历表单中的行数
                for (int j = firstRowNum + 1 ;j < lastRowNum;j++){
                    //获取到一行中的所有数据
                    Row row = sheetAt.getRow(j);
                    Customer customer = new Customer();
                    //获取到一行中所有的列
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    //将表中的数据存入到对象中
                    //获取到所有的列数据
                    if (row != null){
                        //获取到联系人
                        customer.setCompanyperson(row.getCell(1).getStringCellValue());
                        customer.setComname(row.getCell(2).getStringCellValue());
                        customer.setComaddress(row.getCell(3).getStringCellValue());
                        customer.setComphone(row.getCell(4).getStringCellValue());
                    }
                    customers.add(customer);
                    /*for (int k = 0 + 1;k< physicalNumberOfCells;k++){
                        Cell cell = row.getCell(k);
                        String value = ExcelRead.getExcelContent(cell);
                        System.out.print(value+"  ");
                    }
                    System.out.println("");*/
                }
                for (int i1 = 0; i1 < customers.size(); i1++) {
                    customerService.insertCustomer(customers.get(i1));
                }
            }
            map = new HashMap<String, Object>();
            map.put("status",200);
            map.put("message","上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("message","上传失败");
        }
        return  map;
    }
}
