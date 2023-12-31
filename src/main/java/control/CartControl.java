package control;

import dao.DAO;
import entity.Cart;
import entity.Item;
import entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartControl", value = "/cart")
public class CartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        Cookie arr[] = request.getCookies();
//        String txt = "";
//        for (Cookie o : arr) {
//            if (o.getName().equals("id")) {
//                txt = txt + o.getValue();
//                o.setMaxAge(0);
//                response.addCookie(o);
//            }
//        }
//        if (txt.isEmpty()) {
//            txt = id;
//        } else {
//            txt = txt + "," + id;
//        }
//        Cookie c = new Cookie("id",txt);
//        c.setMaxAge(60*60*24);
//        response.addCookie(c);
//        response.sendRedirect("addtocart");
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
