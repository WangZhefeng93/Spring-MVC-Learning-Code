package com.ccff.convert;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateConvert implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        try {
            if (source != null && !"".equals(source.trim())){
                SimpleDateFormat simpleDateFormat = getSimpleDateFormat(source);
                return simpleDateFormat.parse(source);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getSimpleDateFormat(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("^\\d{4}\\d{2}\\d{2}$",source)){
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        return sdf;
    }
}
