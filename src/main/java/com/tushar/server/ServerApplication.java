package com.tushar.server;

import com.tushar.server.models.Server;
import com.tushar.server.models.enumuration.Status;
import com.tushar.server.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Bean
	CommandLineRunner  run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(
				null, "198.168.1.160", "Ubuntu Linux", "16GB",
					"http://localhost:8000/server/image/server1.jpg", "Personal PC", Status.SERVER_UP
			));

			serverRepository.save(new Server(
					null, "198.168.1.161", "MAC OS", "16GB",
					"http://localhost:8000/server/image/server2.jpg","MAC Server PC", Status.SERVER_UP
			));
			serverRepository.save(new Server(
					null, "198.168.1.163", "WINDOWS OS", "16GB",
					"http://localhost:8000/server/image/server3.jpg","Windows Server PC", Status.SERVER_UP
			));
			serverRepository.save(new Server(
					null, "198.168.1.164", "Lerip jobs UK", "16GB",
					"http://localhost:8000/server/image/server4.jpg", "Shell Server PC",Status.SERVER_UP
			));
			serverRepository.save(new Server(
					null, "198.168.1.165", "Lerip jobs US", "16GB",
					"http://localhost:8000/server/image/server1.jpg","MAC Server PC", Status.SERVER_DOWN
			));
			serverRepository.save(new Server(
					null, "198.168.1.167", "Lerip jobs BD", "16GB",
					"http://localhost:8000/server/image/server2.jpg", "SCRIPT Server PC",Status.SERVER_DOWN
			));
			serverRepository.save(new Server(
					null, "198.168.1.168", "NOXBD MAIN", "16GB",
					"http://localhost:8000/server/image/server3.jpg","NOX Server PC", Status.SERVER_UP
			));
			serverRepository.save(new Server(
					null, "198.168.1.169", "NOX LOAN", "16GB",
					"http://localhost:8000/server/image/server4.jpg", "NOX Server PC", Status.SERVER_DOWN
			));
		};
	}

}
