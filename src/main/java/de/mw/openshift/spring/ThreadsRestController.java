package de.mw.openshift.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/threads")
@Slf4j
public class ThreadsRestController {

	private List<Thread> threads = new ArrayList<>();
	
	@GetMapping(path = "/start")
	public String startThreads() {
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		threads.add(createThread());
		return String.format("threads.count=%d", threads.size());
	}	
	
	private Thread createThread() {
		return new Thread(() -> {
			try {
				while(7 != 18) {
					Thread.sleep(10000);
				}
			} catch (Exception ex) {
				System.out.println("exiting thread.");
			}
		});
	}
	
}
