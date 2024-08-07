package com.woongjin.pjt.wsurveyweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
@Slf4j
@SpringBootTest
@ActiveProfiles({"common", "common-local", "local"})
class WsurveyWebApplicationTests {
	@Value("${local.local.key}")
	private String localLocalKey;

	@Value("${local.key}")
	private String localKey;

	@Test
	void contextLoads() {
		System.out.println("localLocalKey = "+localLocalKey);
		System.out.println("localKey = "+localKey);
		log.trace("TRACE!");
		log.debug("DEBUG!");
		log.info("INFO!");
		log.warn("WARN!");
		log.error("ERROR!");
	}

}
