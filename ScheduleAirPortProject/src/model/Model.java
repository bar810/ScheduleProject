package model;

import java.io.IOException;

import Entities.Schedule;

/**
 * model interface
 * 
 * @author bar brownshtein
 *
 */
public interface Model {
	void newSchedule(String args);
	void newWorker(String args) throws IOException;
	void printAllWorkers();
	void deleteWorker();

}
