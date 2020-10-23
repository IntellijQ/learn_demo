package com.yds.stringPartten;

/**
 * @author yds
 * @title: StringParttenTest
 * @description: 字符串匹配
 * @date 2020/8/29 10:21
 */
public class StringParttenTest {
    public static void main(String[] args) {

        String[] target = {"A","A","A","C", "A","A","A","B"};
//        "A","A","A","C", "A","A","A","B"
//         -1  0   1   2
//        "A","A","A","B"
//                         "A","A","A","B"

        String[] pattern = {"A","A","A","B"};
//        int samplePartten = samplePartten(target, pattern);
//        System.out.printf("首次出现匹配字符串位置：%s",samplePartten);

//        String[] pattern1 = {"A","B","A","B","C","A","B","A","A"};
//        String[] pattern1 ={"q","0","e","q","Q"};
        kmpPartten(target,pattern);
    }


    public static int samplePartten(String[] target, String[] pattern){
        int targetNext = 0;
        int patternNext = 0;
        int okIndex = 0;
        int targetLength = target.length;
        int patternLength = pattern.length;
        while (targetNext < targetLength){
            if(pattern[patternNext].equals(target[targetNext])){
                System.out.println("匹配到target[" + targetNext + "] = " + "pattern[" + patternNext + "]");
                patternNext ++;
            }else{
                System.out.println("未匹配到target[" + targetNext + "] = " + "pattern[" + patternNext + "],从pattern 的0 开始");
                patternNext = 0;
                okIndex = targetNext + 1;
            }
            targetNext ++;

            if(patternNext == patternLength){
                return okIndex;
            }
        }
        return 0;
    }

    public static void kmpPartten(String[] target, String[] pattern){
        int[] prefixTable = prefixTable(pattern);
        int okIndex = 0;
        int tIndex = 0;
        int pIndex = 0;
        while(tIndex < target.length){
            if(target[tIndex].equals(pattern[pIndex])){
                System.out.println("target[" + tIndex + "]=" + target[tIndex] +  ",pattern[" + pIndex + "]=" + pattern[pIndex] + "相等");
                tIndex++;
                pIndex++;
            }else{
                int preMaxIndex = prefixTable[pIndex];
                if(preMaxIndex == -1){
                    System.out.println("target[" + tIndex + "]=" + target[tIndex] +  ",pattern[" + pIndex + "]=" + pattern[pIndex] + "不相等，前缀下标值为-1，t下标后移一位,p从0开始");
                    tIndex++;
                    pIndex=0;
                    okIndex = tIndex;
                }else{
                    System.out.println("target[" + tIndex + "]=" + target[tIndex] +  ",pattern[" + pIndex + "]=" + pattern[pIndex] + "不相等，p下标移动到对应的前缀下标，preMaxIndex=" + preMaxIndex);
                    pIndex = preMaxIndex;
                }
            }
        }
        System.out.println("okIndex=" + okIndex);
    }

    public static int[] prefixTable(String[] pattern){
        int length = pattern.length;
        int[] prefix = new int[pattern.length];
        prefix[0] = -1;
        prefix[1] = 0;

        int preMaxLen = 0;
        int currentIndex = 2;
        while (currentIndex < length){
            String preNode = pattern[preMaxLen];
            String lastEnd = pattern[currentIndex - 1];
            System.out.println("pattern[" + (currentIndex - 1) + "]=" + lastEnd +",pattern[" + preMaxLen + "]=" + preNode);
            if(preNode.equals(lastEnd)){
                preMaxLen++;
                prefix[currentIndex] = preMaxLen;
                currentIndex++;
            }else{
                if(preMaxLen > 0){
                    preMaxLen = prefix[preMaxLen - 1];
                }else{
                    prefix[currentIndex] = 0;
                    currentIndex++;
                }
            }

//            preMaxLen = prefix[currentIndex - 1];
//            if(currentIndex == (length -1)){
//                preMaxLen = prefix[currentIndex - 2];//索引=6的地方，最大前缀长度为2
//            }
//            String preNode = pattern[preMaxLen];
//            String current = pattern[currentIndex];
//            if(preNode.equals(current)){
//                if(currentIndex == (length -1)){
//                    prefix[currentIndex] = prefix[preMaxLen];
//                }else{
//                    prefix[currentIndex] = ++preMaxLen;
//                }
//            }else{
//                prefix[currentIndex] = 0;
//            }
//            currentIndex++;
        }

        for(int i=0; i < prefix.length; i++){
            System.out.println(prefix[i]);
        }
        return prefix;
    }
}
