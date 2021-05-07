package pick;

import java.util.Stack;

/**
 * @author yds
 * @title: pick.SortTest
 * @description: TODO
 * @date 2021/4/19 15:58
 */
public class SortTest {


    public static void main(String[] args) {

        int[] input = {6,0,5,3,9};
//        insertSort(input);
//        quickSort(input, 0 , input.length - 1);
        shellSort(input);
    }

    public static void insertSort(int [] input){
        int len = input.length;
        for(int i = 0; i < len; i++){
            int current = input[i];
            for(int j = i - 1; j >= 0; j--){
                int pre = input[j];
                if(pre > current){
                    input[j + 1] = pre;
                    input[j] = current;
                }
            }
        }

        for(int i = 0; i< len; i++){
            System.out.println(input[i]);
        }
    }


    /**
     * 快速排序
     * 从小到大
     */
    public static void quickSort(int [] input, int begin, int end){
        int len = input.length;
        int ll = 0;
        int rr = end;
        int pivot = input[(begin + end) / 2];
        while(ll < rr){
            while(input[ll] < pivot){
                ll++;
            }
            while(input[rr] > pivot){
                rr--;
            }
            if(ll > rr){
                break;
            }
            int temp = input[ll];
            input[ll] = input[rr];
            input[rr] = temp;

            // 左指针移动
            if(input[rr] == pivot){
                ll++;
            }
            // 右指针移动
            if(input[ll] == pivot){
                rr--;
            }
        }

        if(rr == ll){
            ll++;
            rr--;
        }

        if(ll == rr){
            ll++;
            rr--;
        }
        // 左边
        if(begin < rr){
            quickSort(input, begin, rr);
        }

        // 右边
        if(end > ll){
            quickSort(input, ll, end);
        }


        System.out.println("============");
        System.out.println(ll);
        System.out.println(rr);
        System.out.println("============");
        for(int i = 0; i< len; i++){
            System.out.println(input[i]);
        }
    }


    public static void shellSort(int[] input){
        int gap = input.length / 2;
        while (gap > 0){
            for(int i = gap; i < input.length; i++){
                for (int j = i - gap; j >= 0; j -= gap) {
                    int a = input[j];
                    int b = input[j + gap];
                    if(a > b){
                        input[j] = b;
                        input[j + gap] = a;
                    }
                }
            }
            gap = gap / 2;
        }

        for(int i = 0; i< input.length; i++){
            System.out.println(input[i]);
        }
    }

    public String solve (String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        // write code here
        Stack stack = new Stack<String>();
        for(int i = 0; i < str.length(); i++){
            stack.push(String.valueOf(str.charAt(i)));
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
