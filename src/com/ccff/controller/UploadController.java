package com.ccff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
}
