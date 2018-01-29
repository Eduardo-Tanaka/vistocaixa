package br.gov.caixa.vistocaixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.caixa.vistocaixa.repositories.UserRepository;
import br.gov.caixa.vistocaixa.security.transfer.JwtUserDto;
import br.gov.caixa.vistocaixa.security.util.JwtTokenGenerator;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	UserRepository repository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtUserDto user) {
		JwtUserDto u = repository.findByEmail(user.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(user.getPassword(), u.getPassword())) {
			return ResponseEntity.ok(JwtTokenGenerator.generateToken(u, "my-very-secret-key"));
		} else {
			return new ResponseEntity<JwtUserDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody JwtUserDto user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole("usuario");
		JwtUserDto u = repository.save(user);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/token")
	public String token() {
		JwtUserDto u = new JwtUserDto();
		u.setId(1L);
		u.setRole("teste");
		u.setUsername("teste");
		return JwtTokenGenerator.generateToken(u, "my-very-secret-key");
	}
}
