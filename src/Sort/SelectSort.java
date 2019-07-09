package Sort;

/**
 * 简单选择排序
 */
public class SelectSort {

    public static void selectSort(int args[]) {
        for(int i = 0; i < args.length - 1; i++){
            int index = i;
            for(int j = i+1; j < args.length;j++){
                if(args[j] < args[index]){
                    index = j;
                }
            }
            if(index != i){
                int temp = args[i];
                args[i] = args[index];
                args[index] = temp;
            }
        }
    }
    public static void display(int Arrays[]) {
        for (int i = 0; i <Arrays.length ; i++) {
            System.out.print(Arrays[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] Arrays = new int[]{5,1,2,8,3,4,99,0};
        display(Arrays);
        selectSort(Arrays);
        display(Arrays);
    }
}
