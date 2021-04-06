package cn.com.poetry_platform.servlet;
import cn.com.poetry_platform.pojo.User;
import cn.com.poetry_platform.service.UserService;
import cn.com.poetry_platform.utils.ConfigFactory;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 此servle用于登录与注销
 * (通过注解实现，不需要web.xml配置。)
 */
@WebServlet(name = "LoginAndOutServlet", urlPatterns = {"/login.action", "/logout.action"})
public class LoginAndOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 编码
//        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        //        // 获取SERVELT的url-pattern。
        String path = req.getServletPath();
        // 问题：怎么区分到底是“登录”与“注销”
        if ("/login.action".equals(path)) {
            // 登录
            login(req, resp);
        } else if ("/logout.action".equals(path)) {
            // 注销
            logout(req, resp);
        }
    }

    /**
     * 处理登录的
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        // 获取用户表单里面提交的：用户名，和密码
//        String username1 = request.getParameter("username1");
//        String password1 = request.getParameter("password1");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
//
//        String code = request.getParameter("code");
//        String code1 = request.getParameter("code1");
//验证码
//        String sRand =(String) session.getAttribute("sRand");

        System.out.println(username + password);

        // 说明是买家登陆。
        if (StringUtils.isNotEmpty(username)) {
            //买家登陆非空校验
            if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
                UserService userService = new UserService();
                // 调用业务方法进行用户名密码校验。
                User user = userService.login(username, password);
                System.out.println(user);
                if (user != null && (user.getFlag() == 0 || user.getFlag() == 1)) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login.jsp");
                }
            } else {
                // 用户名密码为空：
                response.sendRedirect("login.jsp");
            }
        }
//        else {
//            // 说明是卖家登陆。
//            // 做卖家登陆非空校验。
//            if (StringUtils.isNotEmpty(username1) && StringUtils.isNotEmpty(password1) && sRand.equals(code1)) {
//                UserService userService = new UserService();
//                // 调用业务方法进行用户名密码校验。
//                User user = userService.login(username1, password1);
//                if (user != null && user.getFlag() == 1) {
//                    // 表示登录成功
//                    // 需要把用户信息放入session.
//                    session.setAttribute("user", user);
//                    // 请求往哪里转发： 转发到查询全部的学生信息：StudentsListServlet
//                    // 初始化分页，也就是第一页，查询10条。
//                    int pageSize = ConfigFactory.getInt("common.pageSize", 15);
//                    String path = "goodsByPageManger.action?pageNo=0&pageSize=" + pageSize;
//                    System.out.println("分页初始化：" + path);
//                    request.getRequestDispatcher(path).forward(request, response);
//                    System.out.println("1111");
//                    return;
//                } else {
//                    // 失败了去登录页面：重定向
//                    response.sendRedirect("login.jsp");
//                    // 重定向的底层实现。
//                    //resp.setStatus(302);
//                    //resp.setHeader("Location", "login.jsp");
//                    return;
//                }
//            }
//
    }
    /**
     * 处理注销的
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        // 注销代码比较固定：
        // session销毁
        session.invalidate();
        // 页面跳转: 重定向到登录页面
        response.sendRedirect("login.jsp");
    }
}