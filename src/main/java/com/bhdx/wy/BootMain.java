package com.bhdx.wy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Controller
@SpringBootApplication
@ApiIgnore
@EnableScheduling 
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@EnableHystrixDashboard

public class BootMain{

	public static void main(String[] args) {
		SpringApplication.run(BootMain.class, args);
	}
	
	@RequestMapping("/help")
	public String help() {
		return "redirect:swagger-ui.html";
	}
	
	
}


