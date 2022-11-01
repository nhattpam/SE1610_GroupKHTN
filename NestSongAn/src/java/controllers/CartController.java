/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAOImpl;
import daos.QuantityProductDAOImpl;
import dtos.CartDTO;
import dtos.ProductDTO;
import dtos.QuantityProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CartController", urlPatterns = {"/add-cart"})
public class CartController extends HttpServlet {

    private ProductDAOImpl productDAO = new ProductDAOImpl(DBUtils.getConnection());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
        HttpSession session = request.getSession();
        int branch_id1 = (int) session.getAttribute("branch_id");
//        System.out.println("request: " + branch_id);
//        System.out.println("session cart: " + branch_id1);
        int product_id = Integer.parseInt(request.getParameter("product_id"));
//        System.out.println(product_id);
        
        QuantityProductDAOImpl daoCheck = new QuantityProductDAOImpl(DBUtils.getConnection());
        QuantityProductDTO q = daoCheck.getBranch(product_id, branch_id1);
//        System.out.println("so luong: " + q.getQuantity());
//        int quantityInput = (int) session.getAttribute("quantityInput");
//        System.out.println(quantityInput);
        session.setAttribute("q", q.getQuantity());
//        System.out.println("qu: " + q.getQuantity());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        int branch_id1 = (int) session.getAttribute("branch_id");
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        String command = request.getParameter("command");
        ArrayList<Long> listBuy = null;
        String url = "/cart.jsp";
        try {
            listBuy = (ArrayList<Long>) session.getAttribute("cartID");
            long idBuy = 0;
            if (request.getParameter("cartID") != null) {
                idBuy = Long.parseLong(request.getParameter("cartID"));
            }
            ProductDTO p = productDAO.getProductId(product_id);
            switch (command) {
                case "insert":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartID", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.addToCart(p, 1);
                        TreeMap<ProductDTO, Integer> list = cart.getList();
                        QuantityProductDAOImpl daoCheck = new QuantityProductDAOImpl(DBUtils.getConnection());

                        for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
//                            System.out.println("Hello: " + ds.getKey().getProduct_id());
                            QuantityProductDTO q = daoCheck.getBranch(ds.getKey().getProduct_id(), branch_id1);
//                            System.out.println(ds.getKey().getProduct_id() + ", so luong dang chon: " + ds.getValue() + " co so luong trong kho: " + q.getQuantity());
                            if (ds.getValue() > q.getQuantity()) {
//                                System.out.println(ds.getKey().getProduct_id() + " Vuot qua so luong trong kho");
                                session.setAttribute("wrongQuantity", "Vượt quá số lượng trong kho");
                            }
                        }
                        listBuy.add(idBuy);
                    }
//                    url = "/cart.jsp";
                    url = "shop-products";
                    break;
                case "plus":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartID", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.addToCart(p, 1);
                        TreeMap<ProductDTO, Integer> list = cart.getList();
                        QuantityProductDAOImpl daoCheck = new QuantityProductDAOImpl(DBUtils.getConnection());

                        for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
//                            System.out.println("Hello: " + ds.getKey().getProduct_id());
                            QuantityProductDTO q = daoCheck.getBranch(ds.getKey().getProduct_id(), branch_id1);
//                            System.out.println(ds.getKey().getProduct_id() + ", so luong dang chon: " + ds.getValue() + " co so luong trong kho: " + q.getQuantity());
                            if (ds.getValue() > q.getQuantity()) {
//                                System.out.println(ds.getKey().getProduct_id() + " Vuot qua so luong trong kho");
                                session.setAttribute("wrongQuantity", "Vượt quá số lượng trong kho");
                            }
                        }
                        listBuy.add(idBuy);
                    }
//                    url = "/cart.jsp";
                    url = "my-cart";
                    break;
                case "sub":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartID", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.subToCart(p, 1);
                        TreeMap<ProductDTO, Integer> list = cart.getList();
                        QuantityProductDAOImpl daoCheck = new QuantityProductDAOImpl(DBUtils.getConnection());

                        for (Map.Entry<ProductDTO, Integer> ds : list.entrySet()) {
//                            System.out.println("Hello: " + ds.getKey().getProduct_id());
                            QuantityProductDTO q = daoCheck.getBranch(ds.getKey().getProduct_id(), branch_id1);
//                            System.out.println(ds.getKey().getProduct_id() + ", so luong dang chon: " + ds.getValue() + " co so luong trong kho: " + q.getQuantity());
                            if (ds.getValue() > q.getQuantity()) {
//                                System.out.println(ds.getKey().getProduct_id() + " Vuot qua so luong trong kho");
                                session.setAttribute("wrongQuantity", "Vượt quá số lượng trong kho");
                            }
                        }
                        listBuy.add(idBuy);
                    }
//                    url = "/cart.jsp";
                     url = "my-cart";
                    break;
                case "remove":
                    cart.removeToCart(p);
//                    url = "/cart.jsp";
                     url = "my-cart";
                    break;
                default:
                    break;
            }
            response.sendRedirect(url);
        } catch (NumberFormatException e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
