package com.example.share;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @author yds
 * @title: PosterUtil
 * @description: TODO
 * @date 2020/8/18 19:40
 */
public class PosterUtil {
    private static Poster initPoster(int width, int height, String headerUrl,
                                     String qrCodeUrl,
                                     String userName,String fundName,String profitDesc,String profitValue,String profitRank) {
        Poster poster = new Poster();
        //画布
        poster.setWidth(width);
        poster.setHeight(height);

        //头像
        poster.setHeadUrl(headerUrl);
        poster.setHeadX(0);
        poster.setHeadY(0);
        poster.setHeadWidth(width);
        poster.setHeadHeight(325);

        //名字
        int size = width/17;
        poster.setName(userName + " " + fundName);
        poster.setNameColor(Color.RED);
        poster.setNameFont(new Font("宋体",Font.PLAIN,28));
        poster.setNameY(poster.getHeadY() + poster.getHeadHeight() + 70);
        System.out.println(poster.getNameY());

        //收益率
        poster.setProfit(profitDesc);
        poster.setProfitColor(Color.PINK);
        poster.setProfitFont(new Font("宋体",Font.BOLD,32));
        poster.setProfitY(poster.getNameY() + 60);
        System.out.println(poster.getProfitY());

        //收益率value
        poster.setProfitValue(profitValue);
        poster.setProfitValueColor(Color.BLACK);
        poster.setProfitValueFont(new Font("宋体",Font.BOLD,100));
        poster.setProfitValueX((width-poster.getProfitValue().length()*size)/2);
        poster.setProfitValueY(poster.getProfitY() + 100);
        System.out.println(poster.getProfitValueY());

        //收益率排行
        poster.setProfitRank("超过了" + profitRank + "的用户");
        poster.setProfitRankColor(Color.RED);
        poster.setProfitRankFont(new Font("宋体",Font.BOLD,32));
        poster.setProfitRankX((width-poster.getProfitRank().length()*size)/2);
        poster.setProfitRankY(poster.getProfitValueY() + 100);
        System.out.println(poster.getProfitRankY());

        //小程序码
        poster.setQrCodeUrl(qrCodeUrl);
        poster.setQrCodeWidth((int)(width/2.85));
        poster.setQrCodeHeight((int)(width/2.85));
        poster.setQrCodeX((int)(width/11.5));
        poster.setQrCodeY(height-poster.getQrCodeHeight()-(int)(height/7.68));

        //tips1
        poster.setTip1("长按识别小程序码");
        poster.setTip1Color(Color.BLACK);
        poster.setTip1Font(new Font("宋体",Font.BOLD,width/21));
        poster.setTip1X(poster.getQrCodeX()+poster.getQrCodeWidth()+20);
        poster.setTip1Y(poster.getQrCodeY()+poster.getQrCodeHeight()/2+10);

        //tips2
        poster.setTip2("好物与好友一起分享");
        poster.setTip2Color(Color.GRAY);
        poster.setTip2Font(new Font("宋体",Font.PLAIN,width/27));
        poster.setTip2X(poster.getQrCodeX()+poster.getQrCodeWidth()+25);
        poster.setTip2Y(poster.getQrCodeY()+poster.getQrCodeHeight()/2+60);
        return poster;
    }

    private static void drawPoster(Poster poster) throws Exception {
        long startTime = System.currentTimeMillis();
        String qrCodeUrl = poster.getQrCodeUrl();
        String headUrl = poster.getHeadUrl();
        BufferedImage headImage = ImageIO.read(new File(headUrl));
        BufferedImage qrCodeImage = ImageIO.read(new URL(qrCodeUrl));
        int width = poster.getWidth();
        int height = poster.getHeight();

        //画布
        BufferedImage canvas = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) canvas.getGraphics();
        g.setBackground(Color.WHITE);//设置背景色
        g.clearRect(0, 0, width, height);

        // 设置文字抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //画head
        g.drawImage(headImage.getScaledInstance(
                poster.getHeadWidth(), poster.getHeadHeight(), Image.SCALE_SMOOTH),
                poster.getHeadX(), poster.getHeadY(), null);

        //用户名字
        g.setColor(poster.getNameColor());
        FontMetrics fmName = g.getFontMetrics(poster.getNameFont());
        int stringWidthName = fmName.stringWidth(poster.getName());
        g.setFont(poster.getNameFont());
        g.drawString(poster.getName(), (width - stringWidthName)/2, poster.getNameY());

        //收益率key
        g.setColor(poster.getProfitColor());
        FontMetrics fmProfit = g.getFontMetrics(poster.getProfitFont());
        int stringWidthProfit = fmName.stringWidth(poster.getProfit());
        g.setFont(poster.getProfitFont());
        g.drawString(poster.getProfit(), (width - stringWidthProfit)/2, poster.getProfitY());

//        //收益率value
//        g.setColor(poster.getProfitValueColor());
//        g.setFont(poster.getProfitValueFont());
//        g.drawString(poster.getProfitValue(), poster.getProfitValueX(), poster.getProfitValueY());
//
//        //收益率排行
//        g.setColor(poster.getProfitRankColor());
//        g.setFont(poster.getProfitRankFont());
//        g.drawString(poster.getProfitRank(), poster.getProfitRankX(), poster.getProfitRankY());


//        //画小程序码
//        g.drawImage(qrCodeImage.getScaledInstance(poster.getQrCodeWidth(), poster.getQrCodeHeight(), Image.SCALE_SMOOTH),
//                poster.getQrCodeX(), poster.getQrCodeY(), null);
//        //画tips1
//        g.setColor(poster.getTip1Color());
//        g.setFont(poster.getTip1Font());
//        g.drawString(poster.getTip1(), poster.getTip1X(), poster.getTip1Y());
//        //画tips2
//        g.setColor(poster.getTip2Color());
//        g.setFont(poster.getTip2Font());
//        g.drawString(poster.getTip2(), poster.getTip2X(), poster.getTip2Y());
        //画底部栏
//        g.setColor(poster.getFooterColor());
//        g.fillRect(poster.getFooterX(),poster.getFooterY(),poster.getFooterWidth(),poster.getFooterHeight());
        g.dispose();
        File resultImg = new File("D:\\demo.png");
        ImageIO.write(canvas, "png", resultImg);
        //上传服务器代码
        //ByteArrayOutputStream bs = new ByteArrayOutputStream();
        //ImageOutputStream imgOut = ImageIO.createImageOutputStream(bs);
        //ImageIO.write(canvas, "png", imgOut);
        //InputStream inSteam = new ByteArrayInputStream(bs.toByteArray());
        //String url = OSSFactory.build().upload(inSteam, UUID.randomUUID().toString()+".png");
        System.out.println("生成成功！");
        System.out.println("耗时: " + (System.currentTimeMillis()-startTime)/1000.0 + "s");
        System.out.println("生成文件路径: " + resultImg.getAbsolutePath());
    }


    private static BufferedImage circle(String avatar_img,int width) throws Exception {
        BufferedImage avatar = ImageIO.read(new URL(avatar_img));
        BufferedImage newAvatar = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, width);
        Graphics2D g2 = newAvatar.createGraphics();
        newAvatar = g2.getDeviceConfiguration().createCompatibleImage(width, width, Transparency.TRANSLUCENT);
        g2 = newAvatar.createGraphics();
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(new Rectangle(newAvatar.getWidth(), newAvatar.getHeight()));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2 = newAvatar.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0,width, width, width, width);
        g2.setComposite(AlphaComposite.SrcIn);
        g2.drawImage(avatar, 0, 0, width, width, null);
        g2.dispose();
        return newAvatar;
    }

    public static void main(String[] args) throws Exception {
        String headerUrl = "D:\\head.png";
        String qrCodeUrl = "https://images.xiaogemaicai.cn/StoreQRCodes/201001.jpg";
        int width = 670;
        int height = 971;
        String userName = "张三";
        String fundName = "交银组合";
        String profitDesc = "收益率";
        String profitValue = "38.99%";
        String profitRank = "100%";
        Poster poster = PosterUtil.initPoster(width,
                height,
                headerUrl,
                qrCodeUrl,
                userName,fundName,profitDesc,profitValue,profitRank);
        PosterUtil.drawPoster(poster);
    }
}
