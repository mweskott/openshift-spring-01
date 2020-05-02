package de.mw.openshift.spring;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoopingThread implements Runnable {
	int id;
	
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
			log.warn("exiting thread {}.", id);
		}
	}
}
