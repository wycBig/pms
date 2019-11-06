package com.ujiuye.pro.controller;

import com.ujiuye.cus.bean.Param;
import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.service.AttachmentService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/attach")
public class AttachmentController {

    //获取到Service接口
    @Autowired
    private AttachmentService attachmentService;

    //获取到前台提交的数据，包括文件
    @RequestMapping(value = "/addAttach",method = RequestMethod.POST)
    public String addAttach(MultipartFile multipartFile, Attachment attachment, HttpSession session){
       // ModelAndView mv = new ModelAndView("project-file");
        String path = "F:\\fileUp";
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().
                replaceAll("-","")+multipartFile.getOriginalFilename();
        //文件绝对路径
        String pathFileName = path+"/"+fileName;
        FileOutputStream fos = null;
        InputStream inputStream = null;
        try {
            fos = new FileOutputStream(pathFileName);
            inputStream = multipartFile.getInputStream();
            //IOUtils，copy方法，获取文件的输出流，转化为输出流存入到本地
            IOUtils.copy(inputStream,fos);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //获取到pojo对象,存入到数据库中
        attachment.setPath(pathFileName);
        boolean isSuccess = attachmentService.addAttach(attachment);
        if (isSuccess){
            return "project-file";
        }
        return "project-file";
    }
    //查询所有附件
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ModelAndView getAttachAll(){
        ModelAndView mv = new ModelAndView("project-file");
        //调用service方法，获取到列表
        List<Attachment> attachments = attachmentService.getAttachAll();
        mv.addObject("attach",attachments);
        return mv;
    }
    //下载附件
    @RequestMapping(value = "/upLoad/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> upLoadFile(@PathVariable("id") Integer id){
        Attachment attachment = attachmentService.upLoadFile(id);
        String path = attachment.getPath();
        ResponseEntity<byte[]> responseEntity =null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(path));
            byte[] body = new byte[fis.available()];
            fis.read(body);
            //状态码
            HttpStatus statusCode = HttpStatus.OK;
            String substring = path.substring(path.lastIndexOf("\\"));
            String string = new String(substring.getBytes("gbk"), "iso8859-1");

            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+string);

            responseEntity = new
                    ResponseEntity<byte[]>(body, headers, statusCode);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseEntity;
    }
    //按条件查询
    @RequestMapping(value = "/getCond",method = RequestMethod.GET)
    public ModelAndView getCondition(Param param){
        System.out.println(param);
        ModelAndView mv = new ModelAndView("project-file");
        List<Attachment> attachments = attachmentService.getCondition(param);
        mv.addObject("attach",attachments);
        return  mv;
    }
}
