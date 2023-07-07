package vip.taoshenjia.A06_HttpServletResponse响应对象;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class A03_HttpServletResponse响应对象实现验证码 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置客户端页面自动刷新
        resp.setHeader("Refresh", "3");
        //设置客户端接受elixir
        resp.setContentType("image/jpeg");
        //设置客户端防止缓冲
        resp.setDateHeader("expires", -1);
        //设置客户端设置禁用缓存
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        //创建图片流
        BufferedImage Image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);
        //获取图形
        Graphics2D graphics = (Graphics2D) Image.getGraphics();
       //设置颜色
        graphics.setColor(Color.WHITE);
        //填充矩形
        graphics.fillRect(0, 0, 80, 20);
        //设置颜色
        graphics.setColor(Color.black);
        //设置字体
        graphics.setFont(new Font(null, Font.BOLD, 20));
        //写入字符串
        graphics.drawString(RandomNum(), 0, 20);
        /*图片响应到客户端*/
        ImageIO.write(Image, "jpg", resp.getOutputStream());

    }

    /**生成4位的英文政府+数字*/
    private String RandomNum() {
        String str = "ABCDEFGHIJKLMNOBQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(36));
            sb.append(ch);
        }
        return sb.toString();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
