package Sort;

/**
 * 堆排序
 */
public class HeapSort {
    //最大元素向上调整
    private static void heapfiy(int arrays[], int currentRootNode, int size){
        if(currentRootNode < size){
            int max = currentRootNode;
            int left = 2 * currentRootNode + 1;
            int right= 2 * currentRootNode + 2;
            if(left < size) {
                if (arrays[left] > arrays[max]) {
                    max = left;
                }
            }
            if(right < size) {
                if (arrays[right] > arrays[max]) {
                    max = right;
                }
            }
            if(currentRootNode != max){//如果根元素不是最大元素，则交换
                int temp = arrays[currentRootNode];
                arrays[currentRootNode] = arrays[max];
                arrays[max] = temp;
                heapfiy(arrays,max,size);//继续比较，直到完成一次建堆
            }
        }
    }

    //建堆
    public static void maxHeapfiy(int arrays[],int size){
        for(int i = size - 1; i >= 0; i--){
            heapfiy(arrays, i, size);
        }
    }

    //大堆，堆顶元素最大，每次把堆顶元素放在数组的最后面
    public static void heapSort(int arrays[]){
        for(int i = 0; i < arrays.length; i++){
            maxHeapfiy(arrays,arrays.length-i);
            int temp = arrays[0];
            arrays[0] = arrays[(arrays.length-1)-i];
            arrays[(arrays.length-1)-i] = temp;
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
        heapSort(Arrays);
        display(Arrays);
    }
}
