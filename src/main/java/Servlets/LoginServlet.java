package Servlets;


import Controllers.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("web/Views/Login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = new UserController();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberme = req.getParameter("remember");

        if (userController.isValidLogin(username,password)) {
            req.getSession().setAttribute("user", username);
            if ("yes".equals(rememberme)) {
                Cookie c = new Cookie("user", username);
                c.setMaxAge(7 * 24 * 60 * 60);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("user", null);
                c.setMaxAge(0);
                resp.addCookie(c);

            }
            resp.sendRedirect("web/Views/Products.jsp");
        }  else {
            req.getSession().setAttribute("err_msg", "Username and/or password invalid.");
            resp.sendRedirect("/");
        }


    }
}
