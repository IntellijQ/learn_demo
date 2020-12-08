package com.learn.dataStructure.D6Tree.T2huffman;

import java.util.Arrays;
import java.util.Map;

/**
 * @author yds
 * @title: Huffman
 * @description: 哈夫曼树测试案例
 * @date 2020/11/17 16:40
 */
public class Huffman02TestCode {
    public static void main(String[] args) {
        // 哈夫曼编码测试
        String text = "I LOVE YOU,CHINA!ninid3019mngfnidn";
        byte[] bytes = text.getBytes();
        Huffman02CodeTree<Byte> huffmanTree = new Huffman02CodeTree(bytes);
        ZipResult zipResult = huffmanTree.huffmanZip(bytes);

        System.out.println("压缩前大小：" + zipResult.getBeforeSize());
        System.out.println();

        Map binaryTreePath = huffmanTree.binaryTreePath(huffmanTree.getRoot());
        System.out.println("哈夫曼编码树叶子结点路径：" + binaryTreePath);
        System.out.println();

        System.out.println("哈夫曼编码参照表：" + zipResult.getReferenceTable());
        System.out.println();

        System.out.println("压缩后：" + Arrays.toString(zipResult.getAfterByte()));
        System.out.println("压缩后大小：" + zipResult.getAfterSize());
        System.out.println("压缩比例：" + zipResult.getZipRate());
    }


}
