package control;

import dao.DAO;
import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HandBagControl", value = "/handbag")
public class HandBagControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        DAO dao = new DAO();
        int count = dao.getTotalHandBag();
        int endPage = count / 9;
        if (count % 9 != 0) {
            endPage++;
        }
        List<Product> list = dao.getHandBag(index);

        request.setAttribute("endP", endPage);
        request.setAttribute("listP", list);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("handbag.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
