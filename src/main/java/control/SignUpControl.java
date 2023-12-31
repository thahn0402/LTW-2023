package control;

import dao.DAO;
import entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpControl", value = "/signup")
public class SignUpControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String address = request.getParameter("add");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");
        String repassword = request.getParameter("repass");

        if (!password.equals(repassword)) {
            request.setAttribute("mess", "Mật khẩu không trùng khớp!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            DAO dao = new DAO();
            Account acc = dao.checkAccountExist(email);
            if (acc == null) {
                dao.signUp(userName, address, email, password);
                request.setAttribute("mess", "Đăng kí thành công!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("mess", "Email đã tồn tại!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }

    }
}
