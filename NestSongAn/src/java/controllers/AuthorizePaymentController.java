/**
 * AuthorizePaymentServlet class - requests PayPal for payment.
 *
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.base.rest.PayPalRESTException;
import dtos.OrderDTO;

@WebServlet("/authorize_payment")
public class AuthorizePaymentController extends HttpServlet {

    private static final long serialVersionUID = 2L;

    public AuthorizePaymentController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String order_id = request.getParameter("order_id");
        float subtotal = Float.parseFloat(request.getParameter("subtotal"));
        String shipping = request.getParameter("shipping");
        String tax = "0";
        float total = Float.parseFloat(request.getParameter("subtotal"));

//        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);
        OrderDTO orderDetail = new OrderDTO();
        orderDetail.setOrder_id(order_id);
        orderDetail.setTotal_price(subtotal);

        try {
            PaymentServicesController paymentServices = new PaymentServicesController();
            String approvalLink = paymentServices.authorizePayment(orderDetail);

            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
