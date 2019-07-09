package Sort;

/**
 * 归并排序
 */
public class MergeSort {
    //俩路归并算法，来个拍好序的数组合并为一个数组
    private static void merge(int[] arrays, int left, int mid, int right) {
        //申请一个和原数组一样大小的数组
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arrays[i] <= arrays[j]) {
                temp[k++] = arrays[i++];
            } else {
                temp[k++] = arrays[j++];
            }
        }
        while (i <= mid) {//左边剩余的元素填充进数组
            temp[k++] = arrays[i++];
        }
        while (j <= right) {//右边剩余的元素填充进数组
            temp[k++] = arrays[j++];
        }
        //temp元素拷贝回数组
        for (int t = 0; t < temp.length; t++) {
            arrays[left + t] = temp[t];
        }
    }

    //归并排序
    private static void mergeSort(int[] arrays, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;//划分子序列
            mergeSort(arrays, start, mid);//对左侧子序列进行排序
            mergeSort(arrays, mid + 1, end);//对右侧子序列进行排序
            merge(arrays, start, mid, end);//合并
        }
    }

    public static void display(int Arrays[]) {
        for (int i = 0; i < Arrays.length; i++) {
            System.out.print(Arrays[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] Arrays = new int[]{5, 1, 2, 8, 3};
        display(Arrays);
        mergeSort(Arrays, 0, Arrays.length - 1);
        display(Arrays);
    }
}

