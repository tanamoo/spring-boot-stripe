/*package com.momo.springbootstripe.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.momo.springbootstripe.service.Oder;
import com.momo.springbootstripe.service.PaymentService;
import com.momo.springbootstripe.service.User;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

@Service("paymentServie")
public class PaymentServiceImpl implements PaymentService {
	
	private static final String secretKey = "sk_test_nrE3pvZNVaOrXEMb3r5s4rN9";
	
	public PaymentServiceImpl() {
		Stripe.apiKey = secretKey;
	}

	@Override
	public String createCustomer(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", user.getFisrstName() + " " + user.getLastName());
		customerParams.put("email", user.getEmail());
		
		String id = null;
		
		try{
			//Create customer
			Customer stripeCustomer = Customer.create(customerParams);
			id = stripeCustomer.getId();
			System.out.println(stripeCustomer);
		}catch(CardException e) {
			//Transaction failure
		}catch(RateLimitException e) {
			//Too many requests made to the API too quickly
		}catch(InvalidRequestException e) {
			//Invalid parameters were supplied to Stripe's API
		}catch(AuthenticationException e) {
			//Authentication with Stripe's API failed (wrong API key?)
		}catch(APIConnectionException e) {
			//Network communication with Stripe failed
		}catch(StripeException e) {
			//Generic error
		}catch(Exception e) {
			//Something else happened unrelated to Stripe
		}
		
		return id;
		
	}

	@Override
	public void chargeCreditCard(Order order) {
		// TODO Auto-generated method stub
		int chargeAmountCents = (int) order.getChargeAmountDollars() * 100;
		
		User user = order.getUser();
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", chargeAmountCents);
		chargeParams.put("currency", "usd");
		chargeParams.put("descriprtion", "Monthly Charges");
		chargeParams.put("customer", user.getStripeCustomerId());
		
		try {
			//Submit charge to credit card
			Charge charge = Charge.create(chargeParams);
			System.out.println(charge);
		}catch(CardException e) {
			//Transaction was declined
			System.out.println("Status is:" + e.getCode());
			System.out.println("Message is:" + e.getMessage());
		}catch(RateLimitException e) {
			//Too many requests made to the API too quickly
		}catch(AuthenticationException e) {
			//Authentication with Stripe's API failed（wrong API key?)
		}catch(APIConnectionException e) {
			//Network communication with Stripe failed
		}catch(StripeException e) {
			//Generic error
		}catch(Exception e) {
			//Something else happened unrelated to Stripe
		}
	}
	
	

}*/
