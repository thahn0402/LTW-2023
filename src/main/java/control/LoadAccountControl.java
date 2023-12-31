package control;

import dao.DAO;
import entity.Account;
import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoadAccountControl", value = "/loadaccount")
public class LoadAccountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Account p = dao.getAccountByID(id);

        request.setAttribute("detail", p);
        request.getRequestDispatcher("editaccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
