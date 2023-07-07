package vip.taoshenjia.A06_HttpServletResponse响应对象;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class A02_HttpServletResponse响应对象设置让客户端下载文件 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置客户端接受elixir
        resp.setContentType("image/jpeg");

        /*1.获取客户端要下载文件的路径*/
        String realPath = this.getServletContext().getRealPath("img.png");
        System.out.println(realPath);
        /*1.获取客户端要下载文件的名称*/
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println(filename);
        //3. 设置想办法让浏览器能够支持（Content-Disposition）下载我们需要的东西，中文文件名URLEncoder.encode编码，否则有可能乱码（重庆.png）
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        //4. 通过反射获取资源流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("img/img.png");
        //5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6. 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7. 将FileOutputStream流写到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端！
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);}

        in.close();
        out.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
