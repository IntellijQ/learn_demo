package com.learn.dataStructure.D6Tree.T2huffman;

import com.learn.dataStructure.D6Tree.T1binaryTree.BNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yds
 * @title: Huffman
 * @description: 哈夫曼编码树
 * @date 2020/11/17 16:40
 */
public class Huffman02CodeTree<E> extends Huffman01Tree {
    private Map<Byte, String> referenceTable = new HashMap<>();// 各个叶子结点对应的哈夫曼编码

    public Huffman02CodeTree() {
    }

    /**
     * 构建哈夫曼编码树
     *
     * @param bytes
     * @return
     */
    public Huffman02CodeTree(byte[] bytes) {
        if (bytes.length == 0) {
            return;
        }

        // 统计各个字符出现的次数
        Map<Byte, Integer> byteMap = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            byteMap.put(bytes[i], byteMap.get(bytes[i]) == null ? 1 : byteMap.get(bytes[i]) + 1);
        }

        // 将字符放到数组中
        List<BNode<E>> list = new ArrayList<>();
        byteMap.forEach((key, value) -> {
            BNode BNode = new BNode();
            BNode.setE(key);
            BNode.setWeight(value);
            list.add(BNode);
        });

        // 生成哈夫曼树
        createHuffmanTree(list);
        this.setRoot(list.get(0));
    }

    /**
     * 获取哈夫曼编码参照表
     *
     * @param root
     * @return
     */
    private Map<Byte, String> getHuffmanCodeReferenceTable(BNode root) {
        getHuffmanCodeReferenceTable(root, "", "");
        return referenceTable;
    }


    /**
     * 获取哈夫曼编码参照表
     *
     * @param root      当前结点
     * @param path      路径
     * @param direction 方向 0-左 1-右
     */
    private void getHuffmanCodeReferenceTable(BNode root, String path, String direction) {
        if (root == null) {
            return;
        }

        String str = path + direction;
        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getE() != null) {
                referenceTable.put((byte) root.getE(), str);
            }
        }

        getHuffmanCodeReferenceTable(root.getLeft(), str, "0");
        getHuffmanCodeReferenceTable(root.getRight(), str, "1");
    }


    /**
     * 哈夫曼编码压缩
     *
     * @param bytes
     * @return
     */
    public ZipResult huffmanZip(byte[] bytes) {
        ZipResult zipResult = new ZipResult();

        // 获取哈夫曼编码参照表
        Map<Byte, String> referenceTable = getHuffmanCodeReferenceTable(this.getRoot());

        // 压缩数据
        byte[] afterByte = toZipHuffman(bytes, referenceTable);

        // 压缩比例
        BigDecimal result = (new BigDecimal(bytes.length).subtract(new BigDecimal(afterByte.length)))
                .divide(new BigDecimal(bytes.length), 4, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(100)).setScale(2);

        // 返回哈夫曼压缩结果
        zipResult.setBeforeSize(bytes.length);
        zipResult.setAfterSize(afterByte.length);
        zipResult.setReferenceTable(referenceTable);
        zipResult.setAfterByte(afterByte);
        zipResult.setZipRate(result.toString() + "%");
        return zipResult;
    }

    private byte[] toZipHuffman(byte[] bytes, Map<Byte, String> huffmanCodeReferenceTable) {
        // 根据哈夫曼压缩对照表 组合 压缩后的二进制结果串
        StringBuffer binaryStrBy = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            binaryStrBy.append(huffmanCodeReferenceTable.get(bytes[i]));
        }

        int resultLen = binaryStrBy.length() % 8 == 0 ? binaryStrBy.length() / 8 : binaryStrBy.length() / 8 + 1;
        byte[] afterByte = new byte[resultLen];
        for (int i = 0; i < resultLen; i++) {
            String str = i != resultLen - 1 ? binaryStrBy.substring(8 * i, 8 * (i + 1)) : binaryStrBy.substring(8 * i);
            afterByte[i] = (byte) Integer.parseInt(str, 2);
        }
        return afterByte;
    }


}
