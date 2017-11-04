package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import TableObject.Person;
import hello.MongoDB;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public boolean testing(){
    	MongoDB.addPerson(new Person("Joon", 50, "jkim", "12345", 5, "program1"));
    	MongoDB.reload("jkim", 40);
    	return true;
    }
}
