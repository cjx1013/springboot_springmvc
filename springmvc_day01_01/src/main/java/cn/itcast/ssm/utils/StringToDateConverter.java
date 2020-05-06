package cn.itcast.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("请输入日期");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
          return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换异常");
        }
    }
}
