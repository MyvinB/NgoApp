package com.cts.ngo;

//import brave.sampler.Sampler;
import com.cts.ngo.filter.JwtFilter;
import com.cts.ngo.model.Ngo;
import com.cts.ngo.repository.NgoRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class NgoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NgoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registerBean = new FilterRegistrationBean();
		registerBean.setFilter(new JwtFilter());
		registerBean.addUrlPatterns("/*");
		return registerBean;
	}

//	@Bean
//	public Sampler defaultSampler(){
//		return Sampler.ALWAYS_SAMPLE;
//	}
	@Autowired
	NgoRepository ngoRepository;

	@Override
	public void run(String... args) throws Exception {


	}
}
