package com.sh.crm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/28.
 * 自定义参数绑定，日期类型
 */
public class CustomDataConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

        try {
            System.out.println(simpleDateFormat.parse(s).toString());
            return simpleDateFormat.parse(s);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
