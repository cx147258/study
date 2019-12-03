package cx.test;

import org.apache.commons.codec.DecoderException;

import java.util.zip.DataFormatException;

public class test {

    static int x = 10;
    static {x+=5;}
    public static void main(String[] args) throws DataFormatException, DecoderException {
        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);
        int aa = 1+2/3-4*5;
        System.out.println(aa);
    }
    static {x/=3;}
    int[] a = {1,2,3};

}