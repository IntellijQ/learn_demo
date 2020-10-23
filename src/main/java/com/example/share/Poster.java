package com.example.share;

import lombok.Data;

import java.awt.*;

/**
 * @author yds
 * @title: Poster
 * @description: TODO
 * @date 2020/8/18 19:39
 */
@Data
public class Poster {
    private int width;//海报的宽（像素为单位）
    private int height;//海报的高

    //header
    private String headUrl;//头像url
    private int headX;//头像横坐标
    private int headY;//头像纵坐标
    private int headWidth;//头像宽
    private int headHeight;//头像高

    //用户名字
    private String name;
    private Font nameFont;
    private Color nameColor;
    private int nameY;

    //收益率key
    private String profit;
    private Font profitFont;
    private Color profitColor;
    private int profitY;


    //收益率value
    private String profitValue;
    private Font profitValueFont;
    private Color profitValueColor;
    private int profitValueX;
    private int profitValueY;

    //收益率排行
    private String profitRank;
    private Font profitRankFont;
    private Color profitRankColor;
    private int profitRankX;
    private int profitRankY;

    //小程序码
    private String qrCodeUrl;
    private int qrCodeX;
    private int qrCodeY;
    private int qrCodeWidth;
    private int qrCodeHeight;

    //提示1
    private String tip1;
    private Font tip1Font;
    private Color tip1Color;
    private int tip1X;
    private int tip1Y;

    //提示2
    private String tip2;
    private Font tip2Font;
    private Color tip2Color;
    private int tip2X;
    private int tip2Y;

    //底部栏
    private Color footerColor;
    private int footerWidth;
    private int footerHeight;
    private int footerX;
    private int footerY;
}
