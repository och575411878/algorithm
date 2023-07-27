package com.och.jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 升序是大根堆.栈顶是最小值.降序是大根堆.栈顶是最大值.
 */
public class JianZhi40 {
    // 维护最小堆.堆里最大数.如果小于最大的数就加进去
    // JAVA的堆叫做优先级队列
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if(k==0)return ans;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>
                (){
            // 升序
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        }
        );
        // 先往堆里装满K个数再说
        for(int i=0;i<arr.length;i++){
            if(i<k){
                queue.add(arr[i]);
            }else{
                if(queue.peek()>arr[i]){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        //遍历数组
        for(int i = 0;i<k;i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
}
