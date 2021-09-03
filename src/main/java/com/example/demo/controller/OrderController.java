package com.example.demo.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.global.GlobalData;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Controller
public class OrderController {

	
	@GetMapping("/create_order")
	public String co(Model model)
	{
		model.addAttribute("cartCount",GlobalData.cart.size());

		return "checkout";
	}
	//creating order for payment
	
		@PostMapping("/create_order")
		@ResponseBody
		public String createOrder(@RequestBody Map<String, Object> data) throws Exception
		{
			//System.out.println("hey order function ex");
			System.out.println(data);
			int amt=Integer.parseInt(data.get("amount").toString());
			
			var client = new RazorpayClient("rzp_test_CJoqrREIYW9UcT", "PHUKM0QA1zCb7kRUTfjfhi08");
			
			JSONObject ob = new JSONObject();
			ob.put("amount", amt*100);
			ob.put("currency", "INR");
			ob.put("receipt", "txn_123456");
			//creating new order
			Order order = client.Orders.create(ob);
			System.out.println(order);
			return order.toString();
		}
		
}
