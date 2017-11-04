package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import TableObject.Person;
import TableObject.Retailer;
import hello.MongoDB;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public boolean testing(){
    	// add initial Person
    	MongoDB.addPerson(new Person("Joon", 50, "jkim", "12345", 5, "program1"));
    	MongoDB.addPerson(new Person("Michael",2,"micosoup","2345",2,"program2"));
    	MongoDB.addPerson(new Person("Tim",2,"timchen","345",6,"program1"));
    	
    	// add Retailers
    	MongoDB.addRetailer(new Retailer("Target Wilmington", "1800 Wilmington Drive", "program1"));
    	MongoDB.addRetailer(new Retailer("Joe's Farm", "25 Backyard Road", "program2"));
    	MongoDB.addRetailer(new Retailer("WalMart", "54 Great Branch Road", "program1"));
    	
    	//add Purchase
    	
    	return true;
    }
}
