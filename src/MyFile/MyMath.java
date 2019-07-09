package MyFile;

/**
 * static double ceil(double a)
 * 返回一个大于或等于a的最小双精度实数
 *
 * static double floor(double a)
 * 返回一个小于或等于a的最大双精度实数
 *
 * static double rint(double a)
 * 返回最靠近a的双精度实数
 *
 * static double pow(double a,double b)
 * 返回a的b次方
 *
 * static int round(float a)
 * static long round(double a)
 * 将a四舍五入后返回
 *
 * static double random()
 * 返回大于等于0且小于1的随机数
 *
 * abs(数据类型 a)
 *
 * 返回a的绝对值
 *
 * max(数据类型 a,数据类型 b)
 *
 * 返回a,b中的较大者
 *
 * min(数据类型 a,数据类型 b)
 *
 * 返回a,b中的较小者
 */
public class MyMath {
    public static void main(String[] args){
        System.out.println(Math.ceil(2.3456));
        System.out.println(Math.ceil(3.0456));
    }
}
