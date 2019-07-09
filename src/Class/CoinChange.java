package Class;

//贪心算法
public class CoinChange {
    public static void main(String[] args) {
        //人民币面值集合
        int[] values = {1,2,5,10,20,50,100};
        //各种面值对应数量集合
        int[] count = {3,1,2,1,1,3,5};
        //求442需要各种面值多少张
        int num[] = chang(442,values,count);
        print(num,values);
    }

    private static int[] chang(int money, int[] values, int[] count) {
        int result[] = new int[values.length];
        for(int i = values.length - 1; i >= 0; i--){
            //需要最大面值人民币张数
            int c = 0;
            int temp = money/values[i];
            if(money/values[i] < count[i]){
                c = money/values[i];
            }else{
                c = count[i];
            }
            //剩余的钱数
            money = money - c * values[i];

            result[i] = c;
        }
        return result;
    }

    public static void print(int[] num,int[] values) {
        for (int i = 0; i <values.length ; i++) {
            if(num[i] != 0){
                System.out.println("需要面值为："+values[i]+"的人民币"+num[i]);
            }
        }
    }
}
