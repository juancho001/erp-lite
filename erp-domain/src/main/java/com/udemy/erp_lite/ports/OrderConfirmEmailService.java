package com.udemy.erp_lite.ports;

import com.udemy.erp_lite.order.OrderId;
import com.udemy.erp_lite.shared.Email;
import com.udemy.erp_lite.shared.Money;

/**
* port for Email Server
*/
public interface OrderConfirmEmailService {
    void sendMail(Email email,OrderId orderId,String orderNumber,Money money,String customerName,Integer itemsCount);
}
