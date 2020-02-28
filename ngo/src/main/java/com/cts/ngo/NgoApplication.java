package com.cts.ngo;

import com.cts.ngo.model.Ngo;
import com.cts.ngo.repository.NgoRepository;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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

	@Autowired
	NgoRepository ngoRepository;

	@Override
	public void run(String... args) throws Exception {

//		Map<String, String> mapping = new
//				HashMap<String, String>();
//		mapping.put("name", "name");
//		mapping.put("quantity", "quantity");
//		mapping.put("location", "location");
//
//
//
//		HeaderColumnNameTranslateMappingStrategy<Ngo> strategy =
//				new HeaderColumnNameTranslateMappingStrategy<Ngo>();
//		strategy.setType(Ngo.class);
//		strategy.setColumnMapping(mapping);
//		CSVReader csvReader = null;
//		try {
//			csvReader = new CSVReader(new FileReader
//					("src/main/resources/data.csv"));
//		}
//		catch (FileNotFoundException e) {
//
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		CsvToBean csvToBean = new CsvToBean();
//
//		// call the parse method of CsvToBean
//		// pass strategy, csvReader to parse method
//		List<Ngo> list = csvToBean.parse(strategy, csvReader);
//		for (Ngo e : list) {
//
//
//			ngoRepository.save(e);
//		}
	}
}
