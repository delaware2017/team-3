package hello;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

import TableObject.Person;
import TableObject.Purchase;
import TableObject.Retailer;

@Configuration
public class MongoDB {
	public static MongoOperations mongoOp = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "database"));
    @Bean
    public static boolean initializeDB(){
    	mongoOp.getCollection("Person");
    	mongoOp.getCollection("Purchase");
    	mongoOp.getCollection("Retailer");
    	return true;
    }
    public static void addPurchase(Purchase purchase){
    	mongoOp.getCollection("Purchase");
    	mongoOp.insert(purchase,"Purchase");
    }
    public boolean checkID(Person person){
    	Query query = new Query(Criteria.where("userName").is(person.getUserName()));
    	return mongoOp.exists(query, "Person");
    }
    public static void addPerson(Person person){
    	mongoOp.getCollection("Person");
    	Query query = new Query(Criteria.where("name").is(person.getName()));
    	if (!mongoOp.exists(query, "Person")){
    		mongoOp.insert(person,"Person");
    	}
    }
    
    public static void addRetailer(Retailer retailer){
    	Query query = new Query(Criteria.where("name").is(retailer.getName()));
    	if (!mongoOp.exists(query, "Retailer")){
    		mongoOp.insert(retailer,"Retailer");
    	}
    }
    public static Person getPerson(String userName){
    	Query query = new Query(Criteria.where("userName").is(userName));
    	Person person = mongoOp.findOne(query,Person.class, "Person");
    	return person;
    }
    public static ArrayList<Retailer> getRetailer(String program){
    	Query query = new Query(Criteria.where("program").is(program));
    	return (ArrayList<Retailer>) mongoOp.findAll(Retailer.class,"Retailer");
    }
    public static String logIn(String userName, String pwd){
    	Query query = new Query(Criteria.where("userName").is(userName).andOperator(Criteria.where("password").is(pwd)));
    	if(mongoOp.exists(query, "Person"))
    		return "true";
    	else
    		return "false";
    }
    
    public static void reload(String id, double amount){
    	mongoOp.getCollection("Person");
    	Query query = new Query(Criteria.where("userName").is(id));
    	Person user = mongoOp.findOne(query, Person.class,"Person");
    	user.setBalance(user.getBalance()+amount);
    	mongoOp.remove(query,"Person");
    	mongoOp.insert(user,"Person");
    }
    public static void decrement(String id, double amount){
    	mongoOp.getCollection("Person");
    	Query query = new Query(Criteria.where("userName").is(id));
    	Person user = mongoOp.findOne(query, Person.class,"Person");
    	user.setBalance(user.getBalance()-amount);
    	mongoOp.remove(query,"Person");
    	mongoOp.insert(user,"Person");
    }
    public static ArrayList<Purchase> getPurchase(String userName){
    	Query query = new Query(Criteria.where("userName").is(userName));
    	ArrayList<Purchase> purchases = (ArrayList<Purchase>) mongoOp.find(query,Purchase.class,"Purchase");
    	return purchases;
    }
    
}
