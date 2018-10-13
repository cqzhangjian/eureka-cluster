package org.zj.spring.cloud.eurekawebclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaWebClientApplicationTests {
	
	
	@Autowired
	RestTemplate rt;

	@Test
	public void contextLoads() {
		

		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/index");
		
	}

}
