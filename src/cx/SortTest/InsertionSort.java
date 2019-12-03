package cx.SortTest;

/**
 * 直接插入排序
 */
public class InsertionSort {
    public static void sort(int Arrays[]) {
        int len = Arrays.length;
        for(int i = 1; i < len; i++){
            int temp = Arrays[i];//存储待排序的元素的值
            int insertPoint = i - 1;//与待排序的元素的值做比较的元素的下标
            while(insertPoint >= 0 && Arrays[insertPoint] > temp){//升序
                Arrays[insertPoint+1] = Arrays[insertPoint];//大的元素向后移
                insertPoint--;
            }
            Arrays[insertPoint+1] = temp;
        }
    }
    public static void display(int Arrays[]) {
        for (int i = 0; i <Arrays.length ; i++) {
            System.out.print(Arrays[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] Arrays = new int[]{5,1,2,8,3};
        display(Arrays);
        sort(Arrays);
        display(Arrays);
    }
}
