package com.cts.restaurant;

import brave.sampler.Sampler;
import com.cts.restaurant.filter.JwtFilter;
import com.cts.restaurant.model.Restaurant;
import com.cts.restaurant.repository.RestaurantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
public class RestaurantApplication{

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registerBean = new FilterRegistrationBean();
		registerBean.setFilter(new JwtFilter());
		registerBean.addUrlPatterns("/*");
		return registerBean;
	}

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

	}

