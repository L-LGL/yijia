package com.zt.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// xx2018615001
public class NumberUtil {
    private static Logger log = Logger.getLogger(NumberUtil.class);

    // 根据时间，生成一个随机订单号
    public static String createNumber(){
        String n = "xxx";
        StringBuffer number = new StringBuffer();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        number.append(n).append(year);
        int month = c.get(Calendar.MONTH)+1;
        number.append(month);
        int date = c.get(Calendar.DAY_OF_MONTH);
        number.append(date);
        /*添加时分秒*/
        int house = c.get(Calendar.HOUR_OF_DAY);
        number.append(house);
        int minute = c.get(Calendar.MINUTE);
        number.append(minute);
        int second = c.get(Calendar.SECOND);
        number.append(second);
        number.append(getNumber());
        return number.toString();
    }

    public static String getNumber(){
        File file = new File("C://Users//zt//IdeaProjects//ShopProject//file//number.txt");
        if(!file.exists()){
            log.error("找不到number.txt文件！");
            return "";
        }
        String number = FileUtil.read(file);
        if(number==null){
            FileUtil.write(file,"001");
            return "001";
        }else{
            if(changeDate()){
                String newnumber = addNumber(number);
                FileUtil.write(file,newnumber);
                return newnumber;
            }else {
                FileUtil.write(file, "001");
                FileUtil.write(new File("C://Users//zt//IdeaProjects//ShopProject//file//date.txt"),createDate());
                return "001";
            }
        }
    }

    public static boolean changeDate(){
        File file = new File("C://Users//zt//IdeaProjects//ShopProject//file//date.txt");
        if(!file.exists()){
            log.error("找不到date.txt文件！");
            return false;
        }
        String date = FileUtil.read(file);
        if(date==null){
            String r = createDate();
            FileUtil.write(file,r);
            return true;
        }else{
            String nowdate = createDate();
            if(nowdate.equals(date)) return true;
            else return false;
        }
    }

    public static String addNumber(String s){
        int n = new Integer(s);
        n++;
        String x = n+"";
        int c = 3-x.length();
        for(int i=0;i<c;i++){
            x = "0"+x;
        }
        return x;
    }

    public static String createDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String day = format.format(date);
        return day;
    }

}
