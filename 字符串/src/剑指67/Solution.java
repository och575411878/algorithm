package 剑指67;

class Solution {
    // 如何处理范围是现在的一个问题.
    public int strToInt(String str) {
        str = str.trim();
        if(str.length()==0)return 0;
        int p = 1;
        int curNum = 0;
        char head = str.charAt(0);
        boolean flag = false;
        if(head == '-'){
            flag = true;
        }else if(head <='9'&&head>='0'){
            curNum =  head-'0';
        }else if(head !='+') return 0;
        while(p<=str.length()-1){
            head = str.charAt(p++);
            if(head<='9' && head>='0'){
                if(curNum > 214748364 ||(curNum==214748364&&head>'7')) {
                    return flag?-2147483648:2147483647;
                }
                else curNum = curNum*10 +(head-'0');
            }else break;
        }
        return flag?-curNum:curNum;
    }
}