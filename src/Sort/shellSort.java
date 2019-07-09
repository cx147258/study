package Sort;

/**
 * 希尔排序
 */
public class shellSort {
    private static void shellSort(int arrays[]){
        int len = arrays.length;
        int counter = 1;

        int h = 1;
        while(3 * h + 1 < len){//确定第一轮排序的间隔
            h = 3 * h + 1;
        }

        while(h > 0){
            for(int i = 0; i < h; i++){
                shellInsertSort(i,h,arrays);
            }
            h = (h-1)/3;
            System.out.println("第" + counter + "排序的结果：");
            display(arrays);
            counter++;
        }
    }
    public static void display(int Arrays[]) {
        for (int i = 0; i <Arrays.length ; i++) {
            System.out.print(Arrays[i]+" ");
        }
        System.out.println();
    }
    /**
     * 希尔排序内部使用的插入排序
     */
    private static void shellInsertSort(int beginIndex, int increment, int arrays[]){
        int targetIndex = beginIndex + increment;//将要插入的元素的下标
        while(targetIndex < arrays.length){
            int temp = arrays[targetIndex];
            int previousIndex = targetIndex - increment;
            while(previousIndex >= beginIndex && arrays[previousIndex] < temp){
                arrays[previousIndex + increment] = arrays[previousIndex];
                previousIndex = previousIndex - increment;
            }
            arrays[previousIndex + increment] = temp;//插入到合适的位置
            targetIndex = targetIndex + increment;//插入下一个元素
        }
    }

    public static void main(String[] args) {
        int[] Arrays = new int[]{5,1,2,8,3,4,99,0,11,23,4,1,7,8,5,3,32,3};
        shellSort(Arrays);
    }
}
