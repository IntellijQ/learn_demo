package pick;

import java.util.Scanner;

/**
 * @author yds
 * @title: BagsProblem
 * @description: TODO
 * @date 2021/4/12 10:23
 */
public class StringAll {

    public static void permu(char[] str){
        if(str == null){
            return;
        }
        permu(str,0);
    }

    private static void permu(char[] str,int begin){
        if(begin == str.length){
            System.out.println(str);
        }
        else{
            for(int i = begin; i< str.length; i++){
                //首次for循环时候i=begin，即a,b,c分别和自身交换
                char temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
                // 开始下一个
                permu(str,begin+1);
                //采用递归调用，每次begin+1后 带入新的递归
                //        /*交换一遍后再交换一次，能够保证最后的到的还是原数组，好办法！*/
                temp = str[begin];
                str[begin] = str[i];
                str[i] = temp;
            }
        }



//        if(begin == str.length){
//            System.out.println(str);
//        }else{
//            for (int i = begin; i < str.length; i++){
//                char temp = str[i];
//                str[begin] = str[i];
//                str[i] = temp;
//
//                permu(str, begin + 1);
//
//                temp = str[begin];
//                str[begin] = str[i];
//                str[i] = temp;
//            }
//        }
    }


    public static void main(String[] args){
        System.out.println("请输入一个字符串：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] array = new char[str.length()];
        array = str.toCharArray();
        permu(array);
    }

}
