package com.example.demo.controller;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.global.GlobalData;
import com.example.demo.model.MyOrder;
import com.example.demo.model.User;
import com.example.demo.repository.MyOrderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Controller
public class OrderController {

	@Autowired
	private MyOrderRepository myOrderRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	EmailSenderService emailService;
	
	@GetMapping("/create_order")
	public String co(Model model)
	{
		model.addAttribute("cartCount",GlobalData.cart.size());

		return "checkout";
	}
	//creating order for payment
	
		@PostMapping("/create_order")
		@ResponseBody
		public String createOrder(Model model,@RequestBody Map<String, Object> data,Principal principal,@ModelAttribute("user") User user, HttpServletRequest request) throws Exception
		{
			//System.out.println("hey order function ex");
			System.out.println("Data from FE : "+data);
			int amt=Integer.parseInt(data.get("amount").toString());
			
			var client = new RazorpayClient("rzp_test_CJoqrREIYW9UcT", "PHUKM0QA1zCb7kRUTfjfhi08");
			
			JSONObject ob = new JSONObject();
			ob.put("amount", amt*100);
			ob.put("currency", "INR");
			ob.put("receipt", "txn_123456");
			//creating new order
			Order order = client.Orders.create(ob);
			System.out.println(order);
			//save order in datatbase
		
			MyOrder myorder=new MyOrder();
			myorder.setAmount(order.get("amount"));
			myorder.setOrderId(order.get("id"));
			myorder.setPaymentId(null);
			myorder.setStatus("created");
			myorder.setUser(this.userRepository.getUserByUserName(principal.getName()));
			myorder.setRecept(order.get("receipt"));
//			emailService.sendSimpleEmail(myorder.getUser().getEmail(), 
//					"Dear "+myorder.getUser().getFirstName()+" "+myorder.getUser().getLastName()+" ,\n Your order successfully placed from E-Art Heritage \n  Order Id: "+myorder.getMyOrderId()+"\n Amount:  "
//					+myorder.getAmount()+"\n Payment Id: "+myorder.getPaymentId()+"\n"					
//					+ "Thank You!!!", "E-ART Heritage");
			System.out.println( myorder.getUser().getEmail());
			this.myOrderRepository.save(myorder);
			return order.toString();
		}
		
		
		
		
		
		
		
		
		
		
		@PostMapping("/user/update_order")
		public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object>data,@ModelAttribute("user") User user, HttpServletRequest request){
			
			MyOrder myorder=this.myOrderRepository.findByOrderId(data.get("order_id").toString());
			myorder.setPaymentId(data.get("payment_id").toString());
			myorder.setStatus(data.get("status").toString());
			
			this.myOrderRepository.save(myorder);
			
			
			
			System.out.println(user.getEmail());
			System.out.println(data);
			emailService.sendSimpleEmail(myorder.getUser().getEmail(), 
					"Dear "+myorder.getUser().getFirstName()+" "+myorder.getUser().getLastName()+" ,\n Your order successfully placed from E-Art Heritage \n  Order Id: "+myorder.getMyOrderId()+"\n Amount:  "
					+myorder.getAmount()+"\n Payment Id: "+myorder.getPaymentId()+"\n"					
					+ "Thank You!!!", "E-ART Heritage");
			return ResponseEntity.ok(Map.of("msg","updated"));
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
