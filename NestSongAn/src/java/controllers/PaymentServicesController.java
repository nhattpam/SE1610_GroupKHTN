/**
 * PaymentServices class - encapsulates PayPal payment integration functions.
 *
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package controllers;

import java.util.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;
import dtos.OrderDTO;

public class PaymentServicesController {

    private static final String CLIENT_ID = "AcCGw36sXesBjzC3xgIGldzEhBnFJ_3m0xk15lJmh8wKsTqEfd0qlxjnY8lWsy-nAbY7Jp7fboUbk3zP";
    private static final String CLIENT_SECRET = "EEyDJfdGo5L87fl2YvA-vjEM5K8_yPaW8V7XI77NIeXclxndXJy2qj0TOcftdyBiTcrUn5pPUTwuT5Gl";
    private static final String MODE = "sandbox";

    public String authorizePayment(OrderDTO orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                .setLastName("Peterson")
                .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/NestSongAn/cancel.html");
        redirectUrls.setReturnUrl("http://localhost:8080/NestSongAn/review_payment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(OrderDTO orderDetail) {
        Details details = new Details();
        details.setShipping("0");
        String subTotal = Float.toString(orderDetail.getTotal_price());
        details.setSubtotal(subTotal);
        details.setTax("0");

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(subTotal);
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getOrder_id());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCurrency("USD");
        item.setName(orderDetail.getOrder_id());
        item.setPrice(subTotal);
        item.setTax("0");
        item.setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}
