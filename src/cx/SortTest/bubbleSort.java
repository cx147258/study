package cx.SortTest;

/**
 * 冒泡排序
 */
public class bubbleSort {
    public static void Sort(int arrays[]) {
        for(int i = 0; i < arrays.length - 1; i++){
            for(int j = 1; j < arrays.length - i; j++){
                if(arrays[j-1] > arrays[j]){
                    int temp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }
    public static void display(int arrays[]) {
        for (int i = 0; i <arrays.length ; i++) {
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] Arrays = new int[]{5,1,2,8,3,4,99,0,11,23,4,1,7,8,5,3,32,3};
        display(Arrays);
        Sort(Arrays);
        display(Arrays);
    }
}
