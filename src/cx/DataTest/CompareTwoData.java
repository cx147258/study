package cx.DataTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 比较俩个日期的大小
 */
public class CompareTwoData {

    /***
     * 1.用getTime()方法直接比较俩个日期
     * @param data1
     * @param data2
     * @return
     */
    public static int compareData1(String data1,String data2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try{
            Date d1 = df.parse(data1);//字符串转日期
            Date d2 = df.parse(data2);
            if(d1.getTime() > d2.getTime()){
                System.out.println(data1 + "在" + data2 + "后");
                return 1;
            }else if(d1.getTime() < d2.getTime()){
                System.out.println(data2 + "在" + data1 + "后");
                return -1;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 2.用before()和after方法直接比较俩个日期
     * @param data1
     * @param data2
     * @return
     */
    public static int compareData2(String data1,String data2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try{
            Date d1 = df.parse(data1);//字符串转日期
            Date d2 = df.parse(data2);
            if(d1.before(d2)){
                System.out.println(data1 + "在" + data2 + "前");
                return 1;
            }else if(d1.after(d2)){
                System.out.println(data1 + "在" + data2 + "后");
                return -1;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 3.用compareTo()直接比较俩个字符串
     * @param data1
     * @param data2
     * @return
     */
    public static int compareData3(String data1,String data2) {
        try{
            if(data1.compareTo(data2) < 0){
                System.out.println(data1 + "在" + data2 + "前");
                return 1;
            }else if(data1.compareTo(data2) > 0){
                System.out.println(data1 + "在" + data2 + "后");
                return -1;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        String date1 = "2019-02-01 08:09";
        String date2 = "2018-02-01 08:09";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String date3 = sdf.format(date);//日期转字符串
        System.out.println(date3);

        compareData3(date2,date1);
    }
}
