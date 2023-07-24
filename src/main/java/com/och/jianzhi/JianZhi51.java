package com.och.jianzhi;
public class JianZhi51 {
    // 數組 前数大于后数就是逆序对
    // 常见的转换 累积和
    // 先尝试暴力
    private int count = 0;
    public int reversePairs(int[] nums) {
        process(nums,0,nums.length-1);
        return count;
    }
    private void process(int[] arr, int start, int end) {
        // 都要有参数检测
        if (end - start <= 0) return;// 为什么[],这里没有拦截下来.当为空的时候数组的截止位置为-1.
        int mid = (start + end) / 2;
        process(arr, start, mid);
        process(arr, mid + 1, end);
        merge(arr, start, end, mid);
    }


    /**
     * 将有序的两段合并起来
     * 关键词: 双指针 非原地
     * @param arr
     * @param start
     * @param end
     * @param mid
     */
    private void merge(int[] arr, int start, int end, int mid) {
        int point_left = start;
        int point_right = mid + 1;
        int[] help = new int[end - start + 1];
        int p = 0;
        while (point_left <= mid && point_right <= end) {
            if (arr[point_left] <= arr[point_right]) {
                help[p++] = arr[point_left++];
            } else {
                count+= mid - point_left + 1;
                help[p++] = arr[point_right++];
            }
        }
        while (point_left<= mid){
            help[p++] = arr[point_left++];
        }
        while (point_right <= end) {
            help[p++] = arr[point_right++];
        }
        System.arraycopy(help, 0, arr, start, help.length);
    }
}