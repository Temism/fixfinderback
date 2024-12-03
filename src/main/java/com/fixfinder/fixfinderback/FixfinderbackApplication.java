package com.fixfinder.fixfinderback;

import com.fixfinder.fixfinderback.Models.Usuario;
import com.fixfinder.fixfinderback.repositorio.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FixfinderbackApplication {


	public static void main(String[] args) {
		SpringApplication.run(FixfinderbackApplication.class, args);
	}


}
