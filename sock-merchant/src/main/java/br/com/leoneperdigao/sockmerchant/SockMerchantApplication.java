package br.com.leoneperdigao.sockmerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SockMerchantApplication {
   
	public static void main(String[] args) throws IOException {
		SpringApplication.run(SockMerchantApplication.class, args);
	}

}
