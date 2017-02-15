package com.sh.crm.classes.service.impl;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/28.
 */
public class ClassesServiceImplTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addClasses() throws Exception {
        /**
         * 测试开课状态
         */
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        String a = "2001-03-22 21:24:13";
        String b = "2017-05-22 21:24:13";
        String c = "2001-08-22 21:24:13";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.CANADA);
        String date = simpleDateFormat.format(new Date());
        //System.out.println(date);
        //System.out.println(new Date());
        Date da = simpleDateFormat.parse(a);
        Date db = simpleDateFormat.parse(b);
        Date dc = simpleDateFormat.parse(c);
        System.out.println(new Date());
        if (currentDate.before(da)) {
            System.out.println("现在早于a");

        } else {
            System.out.println("现在晚于a");
        }
        if (currentDate.after(db)) {
            System.out.println("现在晚于b");
        } else {
            System.out.println("现在早于b");
        }


    }

}