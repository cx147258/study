package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class test {



    public static void main(String[] args){
//       int a = 0b0000_0000_0000_0000_0000_1000_0000_0000;//0b开头表示二进制
//       int b = 123_23;//_ 不影响
//       数字的值
//       System.out.println(a);
//       System.out.println(b);
        for(int i = 0; i < 2 ; i++){
            String msgtemplateId = UUID.randomUUID().toString();
            System.out.println(msgtemplateId);
        }
    }
}
