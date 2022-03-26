package org.zsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zsw
 */
@SpringBootApplication
@EnableScheduling
public class HotSearchListApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotSearchListApplication.class, args);
	}

}
