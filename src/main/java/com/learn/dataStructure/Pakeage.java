package com.learn.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: Pakeage
 * @description: TODO
 * @date 2020/7/21 15:13
 */
public class Pakeage {
    static int[] page = {90,5,41,1,2,0,100,39,30,904,89,209,38};
    static List resultPage = new ArrayList<>();

    public static void main(String[] args) {
        int target = 100;
        page(target,0);
        System.out.println(resultPage.toString());
    }

    public static boolean page(int target, int index){
        if(target == 0) return true;

        if(target < 0) return false;

        if(index >= page.length) return false;

        int source = page[index];
        int result = target - source;

        if(page(result, index + 1)){
            resultPage.add(source);
            return true;
        }else{
            return page(target, index + 1);
        }
    }
}
