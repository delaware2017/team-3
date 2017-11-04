package hello;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PostBody.PostBalance;
import PostBody.PostLogIn;
import PostBody.PostRegister;
import TableObject.Person;
import TableObject.Retailer;

@RestController
public class ServerController {
	private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

	
	 @RequestMapping(value = "/getDecrement/{name}/{amount}",method = RequestMethod.GET)
	    public boolean getDecrement(
	    		@PathVariable(value="name") String name,
	    		@PathVariable(value="amount") String amount) {
		 		logger.info("Name is {}, Ammount is {}.", name, amount);
		 		
	       return true;
	    }
	 @RequestMapping(value = "/getBalance/{name}/",method = RequestMethod.POST)
	    public double getBalance(@RequestBody PostBalance body ){
		 		String name = body.getName();
		 		logger.info("Name is {}.", name);
		 		Person user = MongoDB.getPerson(name);
		 		
	       return user.getBalance();
	    }
	 @RequestMapping(value = "/logIn/",method = RequestMethod.POST)
	    public boolean getBalance(@RequestBody PostLogIn body ){
		 		String id = body.getId();
		 		return MongoDB.logIn(body.getId(),body.getPassword());
	    }
	 
	 @RequestMapping(value = "/register/",method = RequestMethod.POST)
	    public void register(@RequestBody PostRegister body ){
		 		String id = body.getId();
		 		String name = body.getName();
		 		String password = body.getPassword();
		 		String program = body.getProgram();
		 		int famSize = body.getFamSize();
		 		Person user = new Person(name,  0,  id,  password,  famSize);
		 		MongoDB.addPerson(user);
	    }
	 @RequestMapping(value = "/getRetailer/{program}",method = RequestMethod.GET)
	    public ArrayList<Retailer> getRetailer(@PathVariable(value="program") String program){
		 		return MongoDB.getRetailer(program);
	    }
	 
	 
}
