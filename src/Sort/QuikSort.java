package Sort;

/**
 * 快速排序
 */
public class QuikSort {

    //填坑法
    private static void Sort(int[] arrays,int left,int right) {
        int start = left;
        int end = right;
        int key = arrays[start];
        while(left < right){
            while(left < right && arrays[right] > key){//从右往左，找到比基准值小的元素
                right--;
            }
            if(left < right){
                arrays[left] = arrays[right];
                left++;
            }
            while (left < right && arrays[left] < key){//从左往右，找到比基准值大的元素
                left++;
            }
            if(left < right){
                arrays[right] = arrays[left];
                right--;
            }
        }
        arrays[left] = key;
        display(arrays);
        if(start < left - 1){
            Sort(arrays,start,left-1);
        }
        if(right + 1 < end) {
            Sort(arrays, right + 1, end);
        }
    }

    public static void display(int Arrays[]) {
        for (int i = 0; i <Arrays.length ; i++) {
            System.out.print(Arrays[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] Arrays = new int[]{5,1,2,8,4,9,0,2};
        display(Arrays);
        Sort(Arrays,0,Arrays.length-1);
        display(Arrays);
    }
}
