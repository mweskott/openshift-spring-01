package de.mw.openshift.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/threads")
public class ThreadsRestController {
	private static final Logger log = LoggerFactory.getLogger(ThreadsRestController.class);

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
		try {
			Thread thread = new Thread(new LoopingThread(threads.size()));
			thread.start();
			return thread;
		} catch (OutOfMemoryError ex) {
			log.error("OOM Exeption while creating thread - exiting jvm", ex);
			System.exit(17);
		}
		return null; // can never hapen
	}
	
}
