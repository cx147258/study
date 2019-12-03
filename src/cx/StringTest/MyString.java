package cx.StringTest;

public class MyString {
    public static void main(String[] args){
        /**
         * 字符串 & 字节数组转换
         * getBytes
         */
//        String str = "hello world";
//        byte date[] = str.getBytes();//字符串转字节数组
//        String str2 = new String(date);//字节数组转字符串
//        String str3 = new String(date,0,5);//部分字节数组转字符串
//        System.out.println(str);
//        System.out.println(str2);
//        System.out.println(str3);
        /**
         * 字符串比较
         * ==
         * equals
         * equalsIgnoreCase
         * compareTo
         */
//        String str1 = "hello world";
//        String str2 = new String("hello world");
//        String str3 = str2;
//        String str4 = "Hello World";
//        System.out.println(str1==str2);// ==比较的是字符串的内存地址
//        System.out.println(str1.equals(str2));//equals比较的是字符串的内容，区分大小写
//        System.out.println(str2.equals(str3));
//        System.out.println(str2.equals(str4));
//        System.out.println(str2.equalsIgnoreCase(str4));//equalsIgnoreCase比较字符串的内容，不区分大小写
//        System.out.println(str4.compareTo(str3));//依据字符串在字典中的顺序，比较字符串的大小
        /**
         * 字符串查找
         * contains
         * indexOf
         * lastIndexOf
         * startsWith
         * endsWith
         */
//        boolean tmp = str4.contains("llo");//查找指定的子字符串是否存在
//        System.out.println(tmp);

//        int index1 = str4.indexOf("o");//从头查找指定字符串的位置，找不到返回-1
//        int index2 = str4.indexOf("ll");
//        int index3 = str3.indexOf("q");
//        System.out.println(index1);
//        System.out.println(index2);
//        System.out.println(index3);

//        int index1 = str4.indexOf("o",3);//从指定位置向后查找字符串，找不到返回-1
//        System.out.println(index1);

//        int index1 = str4.lastIndexOf("o");//从后向前查找字符串的位置，找不到返回-1
//        System.out.println(index1);

//        int index1 = str4.lastIndexOf("o",5);//从指定位置从后向前查找
//        System.out.println(index1);

//        boolean tmp = str4.startsWith("Hel");//判断是否以指定字符串开头
//        System.out.println(tmp);

//        boolean tmp = str4.startsWith("ll",2);//从指定位置判断是否以指定字符串开头
//        System.out.println(tmp);

//        boolean tmp = str4.endsWith("dp");//判断是否以指定字符串结尾
//        System.out.println(tmp);

        /**
         * 字符串替换
         * replaceAll
         * replaceFirst
         */
//        String str5 = "Hello World";
//        System.out.println(str5);
//        System.out.println(str5.replaceAll("o","_"));//全部替换
//        System.out.println(str5.replaceFirst("o","_"));//替换首个

        /**
         * 字符串截取
         * substring
         */
        String str6 = "20013000901";
        System.out.println(str6.substring(9));//从指定位置截取到结尾
        System.out.println(str6.substring(0,9));//截取指定范围的内容

        /**
         * 字符串拆分
         * split
         */
//        String str7 = "Hello World hello world !!!";
//        String s[] = str7.split(" ");//按照指定的字符串全拆分
//        for(int i = 0; i < s.length; i++){
//            System.out.println(s[i]);
//        }
//        String s1[] = str7.split(" ",2);//拆分为指定段数
//        for(int i = 0; i < s1.length; i++){
//            System.out.println(s1[i]);
//        }

        /**
         * 其他方法
         * isEmpty 判空
         * length 长度
         * trim 去空格
         * toLowerCase 转小写
         * toUpperCase 转大写
         */
//        String str7 = "  Hello World hello world !!!   ";
//        System.out.println(str7);
//        System.out.println(str7.isEmpty());//判断是否为空字符串
//        System.out.println(str7.length());//取得字符串长度
//        System.out.println(str7.trim());//去掉左右空格
//        System.out.println(str7.toLowerCase());//全部字符串转小写
//        System.out.println(str7.toUpperCase());//全部字符串转大写
//        System.out.println(str7.concat(" *** "));//字符串连接
    }
}
