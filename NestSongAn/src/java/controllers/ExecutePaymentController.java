/**
 * ExecutePaymentServlet class - execute payment via PayPal.
 *
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet("/execute_payment")
public class ExecutePaymentController extends HttpServlet {

    private static final long serialVersionUID = 2L;

    public ExecutePaymentController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        try {
            PaymentServicesController paymentServices = new PaymentServicesController();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);

            response.sendRedirect("success-order");

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
