package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import Entities.Schedule;
import Entities.Worker;

/**
 * In this class all the algorithms are adjusted, and all the calculations are
 * done here
 * 
 * @author bar brownshtein
 *
 */
public class MyModel extends Observable implements Model {

	ArrayList<Worker> workers;
	ArrayList<Schedule> schedules;
	private BufferedReader in;

	public MyModel() {
//		loadSchedulsFromFile();
//		loadWorkersFromFile();
		workers=new ArrayList<Worker>();
	}

	@Override
	public void newSchedule(String args) {// args=name
		Schedule sc = new Schedule(args, workers);
		schedules.add(sc);
		saveSchedulsToFile();
	}

	Schedule getScheduleByName(String name) {
		for (int i = 0; i < this.schedules.size(); i++)
			if (this.schedules.get(i).name == "name")
				return this.schedules.get(i);
			else
				return null;
		return null;
	}

	public void saveSchedulsToFile() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("Scheduls")));
			oos.writeObject(this.schedules);
			oos.close();
		} catch (IOException e1) {

		}
	}

	public void loadSchedulsFromFile() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream("Scheduls")));
			this.schedules = (ArrayList<Schedule>) ois.readObject();
			ois.close();
		} catch (IOException e1) {

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void saveWorkersToFile() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("Workers")));
			oos.writeObject(this.workers);
			oos.close();
		} catch (IOException e1) {

		}
	}

	public void loadWorkersFromFile() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new GZIPInputStream(new FileInputStream("Workers")));
			this.workers = (ArrayList<Worker>) ois.readObject();
			ois.close();
		} catch (IOException e1) {

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void newWorker(String args)  {

		Scanner reader = new Scanner(System.in);  
		System.out.println("Please enter the name : ");
		String n = reader.nextLine();
		System.out.println("Please enter the PercentJob : ");
		int p = reader.nextInt();
		
		workers.add(new Worker(n, p));
//		saveWorkersToFile();
		System.out.println("Worker " + n + " was added!");
	}

	@Override
	public void printAllWorkers() {
		System.out.println("Printing all workers.......");
		for(int i=0;i<workers.size();i++){
			System.out.println (workers.get(i).getName()+"  ,  "+workers.get(i).getPercentOfJobs());
		}
	}

	@Override
	public void deleteWorker() {
		int flag=0;
		Scanner reader = new Scanner(System.in);  
		System.out.println("choose a worker for delete : ");
		String n = reader.nextLine();
		boolean contain=workers.contains(n);
			for(int i=0;i<workers.size();i++){
				if(workers.get(i).getName().equals(n)){
					workers.remove(i);
					System.out.println("deleting done! ");
					flag=1;
				}
			}
			if(flag==0){
				System.out.println("cannot fond this worker! ");

		}
	}
	
}
