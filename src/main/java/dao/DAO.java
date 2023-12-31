package dao;

import context.DBContext;
import entity.Account;
import entity.Product;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DAO {
    Connection conn = null; //mo ket noi den mysql
    PreparedStatement ps = null; //thuc hien cau lenh query
    ResultSet rs = null; //ket qua tra ve sau khi thuc hien query

    public List<Product> getAllProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product LIMIT ?,9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "SELECT * FROM product WHERE id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                return new Product(productId, productName, base64Image, price, title, description);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Product> getProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE name LIKE ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getProductBySellID(int id, int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE sellId =  ? LIMIT ?, 9";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String query = "delete from product where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addProduct(String name, InputStream inputStream, String price, String title, String description, int sid) {
        String query = "INSERT INTO product(name, image, price, title, description, sellId)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
//            ps.setBytes(2, image);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(2, inputStream);
            }

            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, sid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void editProduct(String name, InputStream inputStream, String price, String title, String description, String pid) {
        String query = "UPDATE product\n" +
                "SET name = ?,\n" +
                " image = ?, \n" +
                " price = ?,\n" +
                " title = ?, \n" +
                " description = ?\n" +
                "WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
//            ps.setString(2, image);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(2, inputStream);
            }
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, pid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Product> getMenClothes(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'nam' LIMIT ?, 9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getChildrenWear(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'te' LIMIT ?, 9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getAccessory(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'pk' LIMIT ?, 9";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getHandBag(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'tui' LIMIT ?, 9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getShoes(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'g' LIMIT ?, 9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Product> getWomenClothes(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE title = 'nu' LIMIT ?, 9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
////                        rs.getBytes(3),
//                        rs.getBlob(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                // Retrieving the image blob from the database
                Blob blob = rs.getBlob(3);

                // Converting blob to base64
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                inputStream.close();
                outputStream.close();

                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String description = rs.getString(6);

                // Creating a Product object with retrieved information
                Product product = new Product(productId, productName, base64Image, price, title, description);
                list.add(product);
            }
        } catch (SQLException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getTotalProduct() {
        String query = "select count(*) from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalMen() {
        String query = "select count(*) from product where title = 'nam';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalWomen() {
        String query = "select count(*) from product where title = 'nu';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalChildren() {
        String query = "select count(*) from product where title = 'te';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalAccessory() {
        String query = "select count(*) from product where title = 'pk';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalHandBag() {
        String query = "select count(*) from product where title = 'tui';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalShoes() {
        String query = "select count(*) from product where title = 'g';";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalProductBySellId(int id) {
        String query = "select count(*) from product where sellId = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Account login(String email, String password) {
        String query = "SELECT * FROM account WHERE email = ? AND password = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String email) {
        String query = "SELECT * FROM account WHERE email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signUp(String userName, String address, String email, String password) {
        String query = "INSERT INTO account(name, address, email, password, isSell, isAdmin) VALUES (?, ?, ?, ?, 0, 0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, address);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Account> getAllAccount(int index) {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM account LIMIT ?,9;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int getTotalAccount() {
        String query = "select count(*) from account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void deleteAccount(String pid) {
        String query = "delete from account where uid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Account getAccountByID(String id) {
        String query = "SELECT * FROM account WHERE uid = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void editAccount(String name, String address, String email, String isSell, String isAdmin, String pid) {
        String query = "UPDATE account\n" +
                "SET name = ?,\n" +
                " address = ?, \n" +
                " email = ?,\n" +
                " isSell = ?, \n" +
                " isAdmin = ?\n" +
                "WHERE uid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, email);
            ps.setString(4, isSell);
            ps.setString(5, isAdmin);
            ps.setString(6, pid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
//    public static void main(String[] args) {
//        DAO dao = new DAO();
////        List<Account> list = dao.getAllAccount(1);
//        Account ac = dao.getAccountByID("2");
//        System.out.println(ac);
////        for (Account p : list) {
////           System.out.println(p);
////       }
//
//    }
}
