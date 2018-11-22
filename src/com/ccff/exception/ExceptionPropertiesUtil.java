package com.ccff.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExceptionPropertiesUtil {
    private Properties properties;  //属性集合对象
    private InputStream inputStream;    //属性文件输入流
    private void init() throws IOException {
        properties = new Properties();
        inputStream = this.getClass().getResourceAsStream("/exceptionMapping.properties");
        properties.load(inputStream);   //将属性文件流装载到Properties对象中
        inputStream.close();    //关闭流
    }

    public String getExceptionMsg(String ExceptionCode) throws IOException {
        init();
        String msg = properties.getProperty(ExceptionCode);
        if (msg != null){
            return msg;
        }else {
            return "未定义的异常";
        }
    }

}
