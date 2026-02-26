package com.example.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobportalApplication.class, args);
	}
//	@Bean
//	CommandLineRunner test(Usersrepository repo) {
//		return args -> {
//			Users u = new Users();
//			u.setName("Varun");
//			u.setEmail("varun@test.com");
//			u.setPassword("v@123");
//			repo.save(u);
//		};
	//}
}
