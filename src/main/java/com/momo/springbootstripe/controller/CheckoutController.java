package com.momo.springbootstripe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momo.springbootstripe.entity.ChargeRequest;

@Controller
public class CheckoutController {
	
	//@Value("${pk_test_Nql8BG1yBMUgsA0ANear0JkX}")
	private String stripePublicKey = "pk_test_Nql8BG1yBMUgsA0ANear0JkX";
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("amount", 50*100);//in cents
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("currency", ChargeRequest.Currency.USD);
		return "checkout";
	}

}
