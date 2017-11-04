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
import TableObject.Person;
import TableObject.Purchase;
import TableObject.Retailer;

@RestController
public class ServerController {
	private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

	//From POS
	 @RequestMapping(value = "/Decrement/{userName}/{amount}/{date}",method = RequestMethod.GET)
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
	 
	 // From Web
	 @RequestMapping(value = "/Reload/{userName}/{amount}",method = RequestMethod.GET)
	    public boolean getReload(
	    		@PathVariable(value="userName") String userName,
	    		@PathVariable(value="amount") String amount) {
		 		double add = Double.parseDouble(amount);
		 		MongoDB.reload(userName, add);
		 		
	       return true;
	    }
	 // From Mobile
	 
	 @RequestMapping(value = "/getBalance/{name}/",method = RequestMethod.POST)
	    public double getBalance(@RequestBody PostBalance body ){
		 		String name = body.getName();
		 		logger.info("Name is {}.", name);
		 		Person user = MongoDB.getPerson(name);
		 		
	       return user.getBalance();
	    }
	 @RequestMapping(value = "/logIn/",method = RequestMethod.POST)
	    public boolean getBalance(@RequestBody PostLogIn body ){
		 		return MongoDB.logIn(body.getId(),body.getPassword());
	    }
	 
	 @RequestMapping(value = "/register",method = RequestMethod.POST)
	    public @ResponseBody void register(PostRegister body ){
		 		String id = body.getId();
		 		String name = body.getName();
		 		String password = body.getPassword();
		 		String program = body.getProgram();
		 		String famSize = body.getFamSize();
		 		logger.info("Name is {}, Program is {}.", name, program);
		 		Person user = new Person(name,  0,  id,  password,  Integer.parseInt(famSize),program);
		 		MongoDB.addPerson(user);
	    }
	 @RequestMapping(value = "/getRetailer/{program}",method = RequestMethod.GET)
	    public ArrayList<Retailer> getRetailer(@PathVariable(value="program") String program){
		 		return MongoDB.getRetailer(program);
	    }
	 @RequestMapping(value = "/getPurchase/{userName}",method = RequestMethod.GET)
	    public ArrayList<Purchase> getPurchase(@PathVariable(value="userName") String userName){
		 		return MongoDB.getPurchase(userName);
	    }
	 
	 
}
