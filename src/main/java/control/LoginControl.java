package control;

import com.mysql.cj.protocol.x.Notice;
import dao.DAO;
import entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/login")
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        DAO dao = new DAO();
        Account acc = dao.login(email, password);
        if (acc == null) {
            request.setAttribute("mess", "Email hoặc mật khẩu sai");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", acc);
            response.sendRedirect("home");
        }
    }
}
