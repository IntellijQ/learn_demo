package com.learn.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: ChangeZ
 * @description: TODO
 * @date 2021/3/31 18:02
 */
public class ChangeZ {
    public static void main(String[] args) {
        String str = "0123456789";

        change(str, 3);
    }

    public static String change(String str, int row) {
        if (row == 0) {
            return "";
        }
        if (row == 1) {
            return str;
        }
        row = Math.min(str.length(), row);

        List<StringBuffer> rowList = new ArrayList<StringBuffer>();
        for (int i = 0; i < row; i++) {
            rowList.add(new StringBuffer());
        }

        int currentRow = 0;
        boolean iDownRow = true;
        for (int i = 0; i < str.length(); i++) {
            rowList.get(currentRow).append(str.charAt(i));
            if(currentRow == row - 1){
                iDownRow = false;
            }else if(currentRow == 0){
                iDownRow = true;
            }
            currentRow += (iDownRow ? 1 : -1);
        }

        StringBuffer result = new StringBuffer();
        rowList.stream().forEach(item->{result.append(item);});
        System.out.println(result);
        return rowList.toString();
    }
}
