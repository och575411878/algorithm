package 剑指11;

class Solution {
    // 有重复数字
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length -1;
        while(left<right){
            int point = (left+right)/2;
            if(numbers[point] > numbers[right]){
                left = point + 1;
            }else if (numbers[point]< numbers[right]){
                right = point;
            }else{
                right--; // 关键点
            }
        }
        return numbers[left];
    }
}
