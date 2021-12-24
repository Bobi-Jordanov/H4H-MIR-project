package com.example.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//		return args ->{
//			userRepository.save(new User("Pinch24","Bobi" , "Jordanov" ,"bobi.j@hotmail.com" , 1));
//			userRepository.save(new User("Joki55","Jovan","Krt","jovan.k@hotmail.com",2));
//			userRepository.save(new User("KremBanana","Ana","Banana","ana.b@hotmail.com",3));
//
//		};
//	}
}
