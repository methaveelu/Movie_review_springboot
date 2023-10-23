package dev.mtv.moviesApp;

import org.springframework.boot.SpringApplication;
//import class called SpringApplication which contains a method called run. so to start your spring applicaion, you need
// to call this run method. So for this case u pass your application class to this method to run your app
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
//importing of the springboot application annotation. so annotations in java are usually to let the complier know what this class does.

@SpringBootApplication
@RestController// an annotation to let framework knows that its not another class but an api controller class

public class MoviesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesAppApplication.class, args);
	}

}
