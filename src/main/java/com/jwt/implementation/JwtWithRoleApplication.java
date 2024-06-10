package com.jwt.implementation;

import com.jwt.implementation.model.Role;
import com.jwt.implementation.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtWithRoleApplication implements CommandLineRunner {
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtWithRoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findByRole("ROLE_USER") == null) {
			roleRepository.save(new Role("ROLE_USER"));
		}
		if (roleRepository.findByRole("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
	}
}
