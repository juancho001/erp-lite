package com.udemy.erp_lite;

import com.udemy.erp_lite.order.OrderId;
import com.udemy.erp_lite.persistence.mail.adapter.GmailAdapter;
import com.udemy.erp_lite.persistence.rest.adapters.JsonPlaceholderCustomerProviderAdapter;
import com.udemy.erp_lite.shared.Email;
import com.udemy.erp_lite.shared.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Currency;

@SpringBootApplication
public class ErpLiteApplication implements CommandLineRunner {

	@Autowired
	JsonPlaceholderCustomerProviderAdapter jsonPlaceholderCustomerProviderAdapter;

	@Autowired
	GmailAdapter gmailAdapter;

	public static void main(String[] args) {
		SpringApplication.run(ErpLiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Email email = Email.of("ing.julio.cesar.alvarez@gmail.com");
		OrderId orderId = OrderId.generate();
		String orderNumber = "2SD-1234-909";
		Money money = Money.of(new BigDecimal("500"), Currency.getInstance("USD"));
		String customerName = "Julio Alvarez Torrecilla";
		int itemCount = 20;

		this.gmailAdapter.sendMail(
				email,
				orderId,
				orderNumber,
				money,
				customerName,
				itemCount
		);

	}


//	@Override
//	public void run(String... args) throws Exception {
//		var r = jsonPlaceholderCustomerProviderAdapter.findById(9L);
//		System.out.println(r.get().name());
//	}


}
