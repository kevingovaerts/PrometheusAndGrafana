package be.ordina.monitoringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitoringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringdemoApplication.class, args);
	}

}
