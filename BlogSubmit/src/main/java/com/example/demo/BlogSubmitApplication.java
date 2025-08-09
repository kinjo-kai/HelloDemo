package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogSubmitApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BlogSubmitApplication.class,args);
	}
	
	@Bean
	CommandLineRunner initData(repository.PostRepository repository) {
		return args->{
			Post p1= new Post();
			p1.setTitle("はじめての投稿");
			p1.setContent("これはブログシステムの最初の記事です。");
			repository.save(p1);
			
			Post p2= new Post();
			p2.setTitle("２つ目の記事");
			p2.setContent("H2コンソールで確認してみましょう。");
			repository.save(p2);
		};
	}
}
