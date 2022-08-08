package com.bezkoder.spring.jpa.postgresql;

import com.bezkoder.spring.conf.Applicationconfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = {Applicationconfig.class})
class SpringBootJpaPostgresqlApplicationTests {

	@Test
	public void contextLoads(){
		System.out.println("Test SpringBoot");
	}

}
