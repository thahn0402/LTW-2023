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

@WebServlet(name = "AddToCartControl", value = "/addtocart")
public class AddToCartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie arr[] = request.getCookies();
//        List<Item> list = new ArrayList<>();
//        DAO dao = new DAO();
//        for(Cookie o : arr){
//            if(o.getName().equals("id")){
//                String txt[] = o.getValue().split(",");
//                for(String s :txt){
//                    Product p = dao.getProductByID(s);
//                    list.add(new Item(p, p.getPrice()));
//                }
//            }
//        }
//        for (int i = 0; i< list.size();i++){
//            int count = 1;
//            for(int j = i +1;j< list.size();j++){
//                if(list.get(i).getProduct().getId() == list.get(j).getProduct().getId()){
//                    count++;
//                    list.remove(j);
//                    j--;
//                    list.get(i).setQuantity(count);
//                }
//            }
//        }
//        for (Cookie o : arr){
//            o.setMaxAge(0);
//            response.addCookie(o);
//        }
//        request.setAttribute("listP", list);
//        request.getRequestDispatcher("cart.jsp").forward(request,response);

        String id = request.getParameter("id");
        String quantity1 = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantity1);
        if (id != null) {
            DAO dao = new DAO();
            Product p = dao.getProductByID(id);
            if (p != null) {
                if (request.getParameter("quantity") != null) {
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                }
                HttpSession session = request.getSession();
                if (session.getAttribute("cartP") == null) {
                    Cart cart = new Cart();
                    List<Item> listItems = new ArrayList<Item>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setProduct(p);
                    item.setPrice(p.getPrice());
                    listItems.add(item);
                    cart.setItems(listItems);
                    session.setAttribute("cartP", cart);
                } else {
                    Cart cart = (Cart) session.getAttribute("cartP");
                    List<Item> listItems = cart.getItems();
                    boolean check = false;
                    for (Item item : listItems) {
                        if (item.getProduct().getId() == p.getId()) {
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (check == false) {
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setProduct(p);
                        item.setPrice(p.getPrice());
                        listItems.add(item);
                    }
                    session.setAttribute("cartP", cart);
                }
                response.sendRedirect("cart");
            } else {
                response.sendRedirect("cart");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
