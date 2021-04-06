package cn.com.poetry_platform.servlet;


import cn.com.poetry_platform.pojo.User;
import cn.com.poetry_platform.service.UserService;
import cn.com.poetry_platform.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用于注册
 */
@WebServlet(name = "RegServlet", urlPatterns = {"/reg.action"})
public class RegServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(RegServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("用户注册！！！");
        HttpSession session = req.getSession();
        // 获取注册的属性：用户名、密码、重复密码
        String username = req.getParameter("username");
        String email=req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        System.out.println(confirmPassword);
        // 注册时候的“校验码”
//        String code = req.getParameter("code");
        // 获取ValidateImageServlet产生的校验码的值。
        //String sRand = (String) req.getAttribute("sRand");
//        String sRand = (String) session.getAttribute("sRand");
//        System.out.println("从session里面获取的校验码是：" + sRand);

        // 非空判断，以及密码与确认密码一致的校验。
        if (StringUtils.isNotEmpty(username) &&
                StringUtils.isNotEmpty(email)&&
                StringUtils.isNotEmpty(password) &&
                StringUtils.isNotEmpty(confirmPassword) &&
                password.equals(confirmPassword)
            /* && code.equals(sRand)*/) {
            // 可以注册。
            UserService userService = new UserService();
            User user = new User();

            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            // 调用业务方法插入用户，然后获得返回值，表示是非插入成功
            boolean bool = userService.addUserBuy(user);
            if (bool) {
                // 成功去登录界面
                resp.sendRedirect("login.jsp");
            } else {
                System.out.println("用户添加失败，注册失败");
                // 失败去注册界面
                resp.sendRedirect("reg.jsp");
            }
        } else {
            // 注册数据有误。
            System.out.println("确认密码不一致");
            resp.sendRedirect("reg.jsp");
        }
    }
}
