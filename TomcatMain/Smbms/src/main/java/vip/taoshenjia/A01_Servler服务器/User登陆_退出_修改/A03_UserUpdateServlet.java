package vip.taoshenjia.A01_Servler服务器.User登陆_退出_修改;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.util.StringUtils;
import vip.taoshenjia.A03_Service业务层.UserLoginService.A01_LoginServiceimplements;
import vip.taoshenjia.A04_Model实体类.User;
import vip.taoshenjia.Utils.Constants常量;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class A03_UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        /**判断请求来的参数  这个的ajax的提交的*/
        if (method!=null&&method.equals("pwdmodify")){
            this.UserIfPassword( req, resp);
            System.out.println(method);

        }

        /**判断请求来的参数  这个的前端的表单提交的*/
        if (method!=null&&method.equals("savepwd")){
            System.out.println(method);
            this.UserUpdateServlet( req,resp) ;

        }





    }
    /**这个方法的判断密码*/
    public static void UserIfPassword(HttpServletRequest req, HttpServletResponse resp) {
        String oldpassword = req.getParameter("oldpassword");

        HashMap<String,String>HashMap = new HashMap<>();
        HttpSession session = req.getSession();


        User user = (User) session.getAttribute(Constants常量.USER_SESSion);
        System.out.println("**"+oldpassword+"**");

        if (user==null){
            HashMap.put("result","sessionereeor");
        }
        if (user.getUserPassword().equals(oldpassword)){

            HashMap.put("result","ture");
        }
        if (!user.getUserPassword().equals(oldpassword)){

            HashMap.put("result","false");
        }
        if (oldpassword==null){
            HashMap.put("result","error");
        }

        resp.setContentType("application/json");
        try {
            PrintWriter writer = resp.getWriter();
            JSONObject jsonObject = (JSONObject) JSON.toJSON(HashMap);
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**这个方法的修改密码的*/
    public void UserUpdateServlet(HttpServletRequest req, HttpServletResponse resp) {
        String newpassword = req.getParameter("password1");

        Object USER = req.getSession().getAttribute(Constants常量.USER_SESSion);


        if (USER!=null&& !StringUtils.isNullOrEmpty(newpassword)){
            User user = (User) USER;
            Integer id = user.getId();

            A01_LoginServiceimplements a01_loginServiceimplements = new A01_LoginServiceimplements();
            Boolean aBoolean = a01_loginServiceimplements.UserUpdate(id, newpassword);
            if (aBoolean){
                req.getSession().removeAttribute(Constants常量.USER_SESSion);
                req.setAttribute("error", "修改密码成功，请从新登陆");

            }else {

                req.setAttribute("error", "修改密码不成功");

            }

            /**请求转发到登陆页面*/
            try {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        req.setAttribute("error", "新密码有问题");

        /**请求转发到登陆页面*/
        try {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
