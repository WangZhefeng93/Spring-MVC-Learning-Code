package com.ccff.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/UploadTest")
public class UploadController {
    /**
     * 显示文件上传页面
     * @return
     */
    @RequestMapping("/upload")
    public String upload(){
        return "upload/upload";
    }

    /**
     * 实现单个文件上传
     * @param photo
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/doUploadSingle")
    public String doUploadSingle(MultipartFile photo, HttpServletRequest request, Model model) throws IOException {
        if (!photo.isEmpty()){
            //服务端的images目录需要手动先创建好
            String path = request.getServletContext().getRealPath("/images");
            //获取原始文件名
            String fileName = photo.getOriginalFilename();
            //新的图片名称（UUID的随机名称）
            String newFileName = UUID.randomUUID() + "-" + fileName;
            //限制文件上传类型
            if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith("gif")){
                File file = new File(path,newFileName);
                //完成上传
                photo.transferTo(file);
                model.addAttribute("fileName",newFileName);
            }else {
                return "upload/fail";
            }
        }
        return "upload/success";
    }

    /**
     * 实现过个文件上传
     * @param images
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/doUploadMore")
    public String doUploadMore(@RequestParam MultipartFile[] images, HttpServletRequest request, Model model) throws IOException {
        //服务端的images目录需要手动先创建好
        String path = request.getServletContext().getRealPath("/images");
        List<String> fileNames = new ArrayList<>();
        for (MultipartFile photo : images){
            if (!photo.isEmpty()){
                //获取原始文件名
                String fileName = photo.getOriginalFilename();
                //新的图片名称（UUID的随机名称）
                String newFileName = UUID.randomUUID() + "-" + fileName;
                //限制文件上传类型
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith("gif")){
                    File file = new File(path,newFileName);
                    //完成上传
                    photo.transferTo(file);
                    fileNames.add(newFileName);
                }else {
                    return "upload/fail";
                }
            }
        }
        if (fileNames.size() > 0){
            model.addAttribute("fileNames",fileNames);
        }
        return "upload/success";
    }

    /**
     * 显示文件下载页面
     * @return
     */
    @RequestMapping("/download")
    public String download(){
        return "upload/download";
    }

    /**
     * 实现文件下载
     * @param request
     * @param filename
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/doDownLoad/{filename}", method = {RequestMethod.GET})
    public ResponseEntity<byte[]> doDownLoad(HttpServletRequest request, @PathVariable("filename") String filename) throws IOException {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        System.out.println(path+"\\"+filename+".jpg");
        File file = new File(path+"\\"+filename+".jpg");
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downliadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment",downliadFileName);
        //application/octet-stream：二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }
}
