package control;

import dao.DAO;
import entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "AddControl", value = "/add")
@MultipartConfig(maxFileSize = 16177215)
public class AddControl extends HttpServlet {
    private static final int BUFFER_SIZE = 8192;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pname = request.getParameter("name");
//        String pimage = request.getParameter("image");
        String pprice = request.getParameter("price");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");


        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();

//        byte[] imageBytes = null;
//        Part filePart = request.getPart("imageFile");
//        if (filePart != null && filePart.getSize() > 0) {
//            InputStream inputStream = filePart.getInputStream();
//            imageBytes = readImageData(inputStream);
//        }

        InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("imageFile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        DAO dao = new DAO();
        dao.addProduct(pname, inputStream, pprice, ptitle, pdescription, sid);

        response.sendRedirect("managerproduct");
    }

    private byte[] readImageData(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        return outputStream.toByteArray();
    }
}
