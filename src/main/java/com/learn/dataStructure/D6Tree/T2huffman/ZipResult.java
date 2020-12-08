package com.learn.dataStructure.D6Tree.T2huffman;

import lombok.Data;

import java.util.Map;

/**
 * @author yds
 * @title: HResult
 * @description: 哈夫曼压缩结果
 * @date 2020/11/19 10:47
 */
@Data
public class ZipResult {
    private int beforeSize;
    private int afterSize;
    private Map<Byte, String> referenceTable;
    private byte[] afterByte;
    private String zipRate;
}
