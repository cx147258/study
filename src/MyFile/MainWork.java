package MyFile;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;

public class MainWork {
        //MD5加密
        public String MD5Util(String data) {
            //获得java提供信息摘要算法加密功能类的一个实例
            MessageDigest md5 = null;
            try {
                md5 = MessageDigest.getInstance("MD5");//输入SHA，则实现SHA加密
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
            //将获取到的string转换成byte数组

            byte[] bytes = data.getBytes();

            //获取MD5计算后的byte值
            byte[] md5byte = md5.digest(bytes);

            //将获取到的byte值转回16进制string
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < md5byte.length; i++) {
                //使用0xff保持转值不出错
                int val = ((int) md5byte[i]) & 0xff;
                if (val < 16) {
                    stringBuffer.append("0");
                } else {
                    stringBuffer.append(Integer.toHexString(val));
                }
            }
            return stringBuffer.toString();
        }

        public static void main(String[] args){
            MainWork util = new MainWork();
            String s = new String("123456");
            System.out.println("原始：" + s);
            System.out.println("MD5后：" + util.MD5Util(s));


        }

}
