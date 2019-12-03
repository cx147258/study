package cx.Utils;

import java.util.Base64;

/**
 * Base64编解码
 *
 * Java实现Base64加解密的方式主要有以下四种（推荐度由低到高）：
 * 1：JDK中的sun.misc套件
 * 2：第三方扩展包 bouncy castle
 * 3：第三方扩展包 commons codec
 * 4：JDK8及更高版本中的 java.util.Base64
 */
public class Base64Test {

    public static void main(String[] args) {

        //第四种方法测试
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        String test = "111111";
        byte[] testByte = test.getBytes();

        //编码
        byte[] encoderTest = encoder.encode(testByte);
        System.out.println(new String(encoderTest));

        //编码第二种方式
        String encoderTest2 = encoder.encodeToString(testByte);
        System.out.println(encoderTest2);

        //解码
        String decoderTest = new String(decoder.decode(encoderTest));
        System.out.println(decoderTest);

    }
}
