package com.test.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by xiaojie.Ma on 2018/12/28.
 */

public class Test {

    public static String MAIL_PATTERN = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";

    public static void main(String[] args) {
        if(Pattern.matches(MAIL_PATTERN, "tric_s_ter@163.com")) {
            System.out.println("111");
        }
    }

    public static int getNumberCode(int length) {
        StringBuffer sb = new StringBuffer("1");
        for(int i = 1; i < length; i++) {
            sb.append("0");
        }
        int code = (int)((Math.random()*9+1)*Integer.parseInt(sb.toString()));
        return code;
    }
}
