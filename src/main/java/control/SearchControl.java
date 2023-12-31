package control;

import dao.DAO;
import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchControl", value = "/search")
public class SearchControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        DAO dao = new DAO();
        int count = dao.getTotalProduct();
        int endPage = 0;
        if (count % 9 != 0) {
            endPage++;
        }

        List<Product> list = dao.getProductByName(txtSearch);

        request.setAttribute("endP", endPage);
        request.setAttribute("listP", list);
        request.setAttribute("tag", index);
        request.setAttribute("txtS", txtSearch);
        request.getRequestDispatcher("shop.jsp").forward(request,response);

    }
}
