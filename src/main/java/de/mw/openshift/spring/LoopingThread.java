package de.mw.openshift.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoopingThread implements Runnable {
	int id;

	private static final Logger log = LoggerFactory.getLogger(LoopingThread.class);
	
	public LoopingThread(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		log.info("running thread {}.", id);
		try {
			while(7 != 18) {
				Thread.sleep(10000);
			}
		} catch (Exception ex) {
			log.warn("interrupting thread {}.", id, ex);
		}
		log.info("exiting thread {}.", id);
	}
}
