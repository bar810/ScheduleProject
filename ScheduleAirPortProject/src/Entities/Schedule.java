package Entities;

import java.util.ArrayList;

public class Schedule {

	public ArrayList<Worker> workers;
	public String[] schedule;
	public String name;

	public Schedule(String name, ArrayList<Worker> workers) {
		this.name = name;
		this.workers = workers;
		this.schedule = new String[14];

	}

	void setSchedule(String[] sc) {
		this.schedule = sc;
	}

	void putWorker(Worker worker, int shift) {
		this.schedule[shift] = worker.name;
	}

	String whoIsWorks(int shift) {
		return this.schedule[shift];
	}

	Boolean checkLimitsForWorker(Worker worker, int shift) {

		// personal limit
		if (!worker.canIWork(shift))
			return false;

		// not have a shift before this shift
		if (shift > 0) {
			if (this.schedule[shift - 1] == worker.name)
				return false;
		}

		// not have a 3 nights in a row with this shift
		if ((shift > 4) && (shift % 2 != 0)) {
			if ((this.schedule[shift - 2] == worker.name) && (this.schedule[shift - 4] == worker.name))
				return false;
		}

		// not have yet a 3 nights in this week
		int numOfNights = 0;
		for (int i = 1; i < shift; i++) {
			if (i % 2 != 0) {
				if (this.schedule[i] == worker.name)
					numOfNights++;
			}
			if (numOfNights >= 3)
				return false;
		}

		// percentJob number
		int numOfShifts = 0;
		for (int i = 0; i < 14; i++)
			if (this.schedule[i] == worker.name)
				numOfShifts++;
		if (numOfShifts >= worker.percentOfJobs)
			return false;

		return true;

	}

	ArrayList<Worker> getAllPosiblleWorkers(int shift) {
		ArrayList<Worker> pw = new ArrayList<Worker>();
		for (int i = 0; i < this.workers.size(); i++) {
			if (checkLimitsForWorker(this.workers.get(i), shift) == true)
				pw.add(this.workers.get(i));
		}
		return pw;
	}

	Worker chooseWorkerBypriority(ArrayList<Worker> optionalWorkers) {

		// the Considerations to choose worker are:
		// who have the less of the shifts until now.
		// who do not have two shifts in a row (days or nights) - (in the
		// future)

		// less shift
		int min = 0;
		int numOfShifts;
		Worker w = optionalWorkers.get(0);

		for (int i = 0; i < optionalWorkers.size(); i++) {
			numOfShifts = 0;
			for (int j = 0; j < 14; j++) {
				if (this.schedule[j] == optionalWorkers.get(i).name)
					numOfShifts++;
			}
			if (optionalWorkers.get(i).percentOfJobs - numOfShifts > min) {
				min = optionalWorkers.get(i).percentOfJobs - numOfShifts;
				w = optionalWorkers.get(i);
			}
		}
		return w;
	}

	void buildSchedule() {
		// build the schedule shift by shift
		for (int i = 0; i < 14; i++)
			putWorker(chooseWorkerBypriority(getAllPosiblleWorkers(i)), i);
	}

	void displaySchedule() {
		System.out.println("Shedule:   " + this.name + " :");
		System.out.println();
		System.out.println();
		for (int i = 0; i < 14; i++)
			if (this.schedule[i] == null)
				this.schedule[i] = "         ";

		System.out.println("-----------------------------------------");
		System.out.println("|   Shift    |    Day     |    Night    |");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  SunDay    |  " + this.schedule[0] + " |  " + this.schedule[1] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  MonDay    |  " + this.schedule[2] + " |  " + this.schedule[3] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  TuesDay   |  " + this.schedule[4] + " |  " + this.schedule[5] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  WednesDay |  " + this.schedule[6] + " |  " + this.schedule[7] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  ThursDay  |  " + this.schedule[8] + " |  " + this.schedule[9] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|   FriDay   |  " + this.schedule[10] + " |  " + this.schedule[11] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
		System.out.println("|            |            |             |");
		System.out.println("|  SaturDay  |  " + this.schedule[12] + " |  " + this.schedule[13] + "  |");
		System.out.println("|            |            |             |");
		System.out.println("-----------------------------------------");
	}

}
