package hello;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import PostBody.PostBalance;
import PostBody.PostLogIn;
import PostBody.PostRegister;
import PostBody.PurchaseObject;
import PostBody.RetailerObject;
import PostBody.LogInSuccess;
import TableObject.Person;
import TableObject.Purchase;
import TableObject.Retailer;

@RestController
public class ServerController {
	private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

	//From POS get Amount to decrement
	 @RequestMapping(value = "/decrement/{userName}/{amount}/{date}",method = RequestMethod.GET)
	    public boolean getDecrement(
	    		@PathVariable(value="userName") String userName,
	    		@PathVariable(value="amount") String amount,
	    		@PathVariable(value="date") String date) {
		 	DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		 	Date day = new Date();
		 	try {
		 		day = df.parse(date);
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	}

		 	double add = Double.parseDouble(amount);
	 		MongoDB.decrement(userName, add);
	 		Purchase purchase = new Purchase(add, day ,userName);
	 		MongoDB.addPurchase(purchase);
	       return true;
	    }
	 
	 // From Web Get amount to reload
	 @RequestMapping(value = "/reload/{userName}/{amount}",method = RequestMethod.GET)
	    public boolean getReload(
	    		@PathVariable(value="userName") String userName,
	    		@PathVariable(value="amount") String amount) {
		 		double add = Double.parseDouble(amount);
		 		MongoDB.reload(userName, add);
		 		
	       return true;
	    }
	 // From Mobile
	 // Get current balance
	 @RequestMapping(value = "/getBalance/{name}/",method = RequestMethod.GET)
	    public Person getBalance(@PathVariable(value="userName") String userName ){
		 		Person user = MongoDB.getPerson(userName);
		 		
	       return user;
	    }
	 // Check Login
	 @RequestMapping(value = "/logIn/{userName}/{password}",method = RequestMethod.GET)
	    public LogInSuccess getBalance(
	    		@PathVariable(value="userName") String userName,
	    		@PathVariable(value="password") String password){
		 		LogInSuccess success = new LogInSuccess (MongoDB.logIn(userName,password));
		 		return success;
	    }
	 
	 // Register new Account
	 @RequestMapping(value = "/register/{userName}/{password}/{name}/{program}/{famSize}",method = RequestMethod.GET)
	    public void register(
	    		@PathVariable(value="userName") String userName,
	    		@PathVariable(value="password") String password,
	    		@PathVariable(value="name") String name,
	    		@PathVariable(value="program") String program,
	    		@PathVariable(value="famSize") String famSize
	    		){
		 		logger.info("Name is {}, Program is {}.", name, program);
		 		Person user = new Person(name,  0,  userName,  password,  Integer.parseInt(famSize),program);
		 		MongoDB.addPerson(user);
	    }
	 // Get list of all retailers
	 @RequestMapping(value = "/getRetailer/{program}",method = RequestMethod.GET)
	    public RetailerObject getRetailer(@PathVariable(value="program") String program){
		 		return new RetailerObject(MongoDB.getRetailer(program));
	    }
	 //Get list of purchases
	 @RequestMapping(value = "/getPurchase/{userName}",method = RequestMethod.GET)
	    public PurchaseObject getPurchase(@PathVariable(value="userName") String userName){
		 		return new PurchaseObject(MongoDB.getPurchase(userName));
	    }
	 
	 
}
