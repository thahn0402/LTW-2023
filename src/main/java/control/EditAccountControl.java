package control;

import dao.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAccountControl", value = "/editaccount")
public class EditAccountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String paddress = request.getParameter("address");
        String pemail= request.getParameter("email");
        String pisSell = request.getParameter("isSell");
        String pisAdmin = request.getParameter("isAdmin");

        DAO dao = new DAO();
        dao.editAccount(pname, paddress, pemail, pisSell, pisAdmin, pid);
        response.sendRedirect("manageraccount");
    }
}
