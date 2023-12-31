package control;

import dao.DAO;
import entity.Account;
import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerAccountControl", value = "/manageraccount")
public class ManagerAccountControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        DAO dao = new DAO();
        int count = dao.getTotalAccount();
        int endPage = count / 9;
        if (count % 9 != 0) {
            endPage++;
        }
        List<Account> list = dao.getAllAccount(index);

        request.setAttribute("endP", endPage);
        request.setAttribute("listP", list);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("manageraccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
