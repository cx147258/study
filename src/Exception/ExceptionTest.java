package Exception;


/***
 * java常见异常
 * ClassCastException              类型转换异常
 * ClassNotFoundException          未找到相应类异常
 * ArithmeticException             算数异常
 * ArrayIndexOutOfBoundsException  数组越界异常
 * ArrayStoreException             数组中包含不兼容的值抛出的异常
 * SQLException                    数据库操作异常
 * NullPointerException            空指针异常
 * NoSuchFieldException            字段未找到异常
 * NoSuchMethodException           方法未找到异常
 * NumberFormatException           字符串转为数字抛出的异常
 * NegativeArraySizeException      数组元素个数为负抛出的异常
 * StringIndexOutOfBoundsException 字符串索引超出范围抛出的异常
 * IOException                     输入输出异常
 * ILegalAccessException           不允许访问某类异常
 * FiledNotFoundException          文件未找到异常
 */

public class ExceptionTest {

    public static void main(String[] args) {

        try{

            String str = "dddd";
            int age = Integer.parseInt(str);
            System.out.println(age);
        }catch(Exception e){

//            System.out.println(e);
            e.printStackTrace();//指出异常的类型、性质、栈层次以及出现在程序中的位置
//            e.toString();//输出异常的类型与性质
//            e.getMessage();//输出错误性质
        }
    }
}
