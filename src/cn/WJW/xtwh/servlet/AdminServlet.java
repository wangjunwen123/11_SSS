package cn.WJW.xtwh.servlet;

import cn.WJW.xtwh.domain.Admin;
import cn.WJW.xtwh.service.AdminService;
import cn.WJW.xtwh.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WJW on 2019/3/22.
 */
@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private AdminService service = new AdminServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 设置响应头
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            // 1:接收参数,中文会怎样？出错
//            String name = request.getParameter("name");
//            String pwd = request.getParameter("password");
            // 2:封装对象
            // Admin admin = new Admin(null, name, pwd, null);  // 默认值用0好不好？不好，改用null

            Admin admin = new Admin();
            BeanUtils.populate(admin,request.getParameterMap());

            // 3:查询数据库
            admin = service.login(admin);
            // 4:判断登陆是否成功
            if (admin == null) {
                System.out.println("登陆失败：" + admin);
                //response.getWriter().print("<span style='color:red'>登陆失败</span>");
                // 跳去登陆页，重新登陆
                // 重定向，标准路径， 302 ,是2次请求，不能带数据
//            response.sendRedirect(request.getContextPath() + "/login.jsp");

                // 请求转发，可以携带数据，路径直接写，是服务器端发出的，浏览器不知道，所有是在一次请求之内的
                request.setAttribute("name", admin.getName());  //放数据到request
                request.setAttribute("msg","登陆失败！请检查用户名或密码！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                System.out.println("登陆成功：" + admin);
                response.getWriter().print("<span style='color:green'>登陆成功</span>");
                // 跳去后台管理主界面

            }
        } catch (Exception e) {
            // 错误信息
            request.setAttribute("msg","错误！");
            request.getRequestDispatcher("/jsp/msg.jsp").forward(request,response);
        }

    }
}
