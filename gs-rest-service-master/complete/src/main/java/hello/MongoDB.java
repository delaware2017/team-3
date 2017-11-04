package hello;
import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;

@Configuration
public class MongoDB {
	
    @Bean
    public static boolean testDB(){
    	MongoOperations mongoOp = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "test"));
    	mongoOp.createCollection("testCol");
    	return true;
    }
}
