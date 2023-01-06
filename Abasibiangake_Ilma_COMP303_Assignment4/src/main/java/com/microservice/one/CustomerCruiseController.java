package com.microservice.one;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomerCruiseController implements ErrorController {
	@Autowired 
	private CustomerRepository customerRepo;
	
	@Autowired 
	private CruiseRepository cruiseRepo;
	@Autowired 
	private BookingRepository bookingRepo;
	
	//get the login page
	@GetMapping("/")
	public String home()
	{
		return "index";
		
	}
	
	//route to the dashboard which is the cruise page
	@GetMapping("/cruise")
	public String dashboard(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		model.addAttribute("cruiselist", cruiseRepo.findAll());

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Iterable<Customer> iterator = customerRepo.findAll();
        iterator.forEach(item -> System.out.println(item));

		System.out.println(customerRepo.findByEmail(email));
		Customer loginEmp = customerRepo.findByEmail(email);
		System.out.println(loginEmp.getPassword());
		if (email.equals(loginEmp.getEmail()) && password.equals((loginEmp.getPassword()))) {
			model.addAttribute("email", loginEmp.getEmail());
			return "cruise";
		} else {
			return "error";
		}

		
	}
	
	//route to the registration page
	@GetMapping("/registration")
	public String registrationPage()
	{
		return "register";
	}
	
	//get mapping from the registration page
	@PostMapping("/cruise")
	public String add( Model model,
			@RequestParam("FirstName") String FirstName,
			@RequestParam("LastName") String LastName,
			@RequestParam("Address") String Address,
			@RequestParam("City") String City,
			@RequestParam("Country") String Country,
			@RequestParam("phoneNumber") long phoneNumber,
			@RequestParam("password") String password,
			@RequestParam("email") String email)
	{
		Customer customer = new Customer(FirstName, LastName, Address, City, Country,
			phoneNumber, email, password);
		customerRepo.save(customer);
		model.addAttribute("cruiselist", cruiseRepo.findAll());
		return "cruise";
	}


	//route to the registration page
	@GetMapping("/book/{cruiseId}")
	public String bookingPage(@PathVariable("cruiseId") int cruiseId, 
			@Validated Cruise cruise, BindingResult result, Model model)
	{
//		if(result.hasErrors()) {
//			return "cruise";
//		}
		System.out.println("this is cruiseId"+ cruiseId);
		Cruise cruiseById = cruiseRepo.findById(cruiseId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid cruise id:" + cruiseId));
		System.out.println("This is the cruise name: "+ cruiseById.getCruiseName());
		model.addAttribute("CruiseName", cruiseById.getCruiseName());
		model.addAttribute("Price", cruiseById.getPrice());
		model.addAttribute("cruisee",cruiseById);
		

		return "booking";
	}
	
	//route to the booking page
	@PostMapping("/book/{cruiseId}")
	public String addbookingPage(@PathVariable("cruiseId") int cruiseId,
			@RequestParam(value="noOfGuest", required=false) Integer noOfGuest,
			@Validated Cruise cruise, BindingResult result, Model model)
	{
		
//		if(result.hasErrors()) {
//			return "cruise";
//		}
		if(noOfGuest == null) {
			noOfGuest = 1;
	    }
		Cruise cruiseById = cruiseRepo.findById(cruiseId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid cruise id:" + cruiseId));
		System.out.println("This is the cruise name: "+ cruiseById.getCruiseName());
		model.addAttribute("CruiseName", cruiseById.getCruiseName());
		model.addAttribute("Price", cruiseById.getPrice());
		model.addAttribute("TotalPrice", calculateTotalBookingFee(cruiseById.getPrice(), noOfGuest ));
		model.addAttribute("cruisee", cruiseById);
		model.addAttribute("noOfGuest", noOfGuest);
		return "booking";
	}
	

	//route to the checkout page   /{CustId}/{CruiseId}/{NumberOfGuests}/{status}
	@PostMapping("/checkout/{TotalPrice}/{cruiseId}/{noOfGuest}")
	public String checkoutPage(@PathVariable("TotalPrice") double TotalPrice, @PathVariable("cruiseId") int cruiseId, 
			@PathVariable("noOfGuest") Integer noOfGuest, Model model)
	{
		model.addAttribute("TotalPrice", TotalPrice).toString();
		
		return "checkout";
	}
	

	//route to the checkout page
	@GetMapping("/profile")
	public String historyProfilePage(Model model) throws Exception
	{
		model.addAttribute("bookinglist", bookingRepo.findAll());
//		Cruise cruiseById = cruiseRepo.findByCruiseName("Africa Tour");
//		if(cruiseById==null) {
//			throw new Exception("This cruise cannot be found");
//		}
		return "history";
	}
	
	//route to the success page
	@PostMapping({"/checkout/{TotalPrice}/{cruiseId}/{noOfGuest}/success", "/checkout/{TotalPrice}/{cruiseId}/success"})
	public String successPage(@PathVariable("TotalPrice") double TotalPrice, @PathVariable("cruiseId") int cruiseId, 
			@PathVariable(value="noOfGuest", required=false) Integer noOfGuest, Model model)
	{
		
		Booking booking = new Booking(1, cruiseId, noOfGuest, TotalPrice, "booked");
		bookingRepo.save(booking);
		return "successPage";
		
	}

	@GetMapping("/error")
	public String errorMessage() {
		
		return "error";
	}
	
	public double calculateTotalBookingFee(double initialPrice, Integer noOfGuest) {
		double price = initialPrice * noOfGuest;
		return price;
	}
		
}
