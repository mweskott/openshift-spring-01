package de.mw.openshift.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ThreadsRestControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void sendHelloWorld() throws Exception {
		String responseText = mockMvc.perform(get("/threads/start")).andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString();
		Assertions.assertThat(responseText).isEqualTo("threads.count=10");
	}

}
