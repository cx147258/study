package utils;

import java.util.Random;

/**
 * java的随机数生成测试。共3种获取随机数的方法
 * （1）通过System.currentTimeMills()来获取一个当前时间毫秒数的long型数字
 * （2）通过Math.random（）返回0到1之间的double值
 * （3）通过Random类来生成一个随机数，这个是专业的Random工具类，功能强大
 */
public class RandomTest {
    public static void main(String args[]){
//        testSystemTimeMills();
//        testMathRandom();
//
//        testRandomAPIs(new Random(),"test1");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int i = 0; i < 2; i++){
            testSSQ();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    //1:测试System的currentTimeMills
    private static void testSystemTimeMills(){
        final long l = System.currentTimeMillis();
        final int i = (int)(l%100);
        System.out.printf("System.currentTimeMillis() : l = %s  i = %s\n",l,i);
    }

    //2.测试Math的Random
    private static void testMathRandom(){
        //通过Math.random()函数返回一个double类型随机数，范围[0.0 , 1.0)
        final double d = Math.random();
        //通过d获取[0 , 36)之间的整数
        final int i = (int)(d*100);
        System.out.printf("Math.random : d = %s i = %s\n",d,i);
    }

    //3.测试Random的API
    private static void testRandomAPIs(Random random , String title){
        final int BUFFER_LEN = 5;

        //获取随机的boolean值
        boolean b = random.nextBoolean();
        //获取随机的数组buf[]
        byte[] buf = new byte[BUFFER_LEN];
        random.nextBytes(buf);
        //获取随机的Double值，范围[0.0,1.0)
        double d = random.nextDouble();
        //获取随机的float值，范围[0.0,1.0)
        float f = random.nextFloat();
        //获取随机的int值
        int i1 = random.nextInt();
        //获取随机的[0.100)的int值
        int i2 = random.nextInt(100);
        //获取随机的long值
        long l = random.nextLong();
        //获取随机的高斯分布的double值
        double g = random.nextGaussian();

        System.out.printf("%s : b = %s\nd = %s\nf = %s\ni1 = %s\ni2 = %s\nl = %s\n" +
                "g = %s\n",title,b,d,f,i1,i2,l,g);
        for(byte bt : buf){
            System.out.printf("%s, ",bt);
        }
        System.out.println();
    }

    //4.双色球
    private static void testSSQ(){
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            System.out.printf("%-6s",random.nextInt(32)+1 + "   ");
        }
        System.out.printf("%-6s",random.nextInt(15)+1 + "   ");
        System.out.println();
    }
}
