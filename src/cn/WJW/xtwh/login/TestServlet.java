package cn.WJW.xtwh.login;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by WJW on 2019/3/8.
 */
public class TestServlet implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.err.println("初始化了。。。" + this);
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.err.println("有人请求了。。。。" + this);
    }

    @Override
    public void destroy() {
        System.err.println("销毁了。。。" + this);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
