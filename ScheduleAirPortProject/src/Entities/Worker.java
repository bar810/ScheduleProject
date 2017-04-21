package Entities;

public class Worker {

	String name;
	int percentOfJobs;
	int[] limits;

	public Worker(String name, int percentOfJobs) {
		this.name = name;
		this.percentOfJobs = percentOfJobs;
		this.limits = new int[14];
	}

	int getPercentOfJobs() {
		return this.percentOfJobs;
	}

	void setLimits(int[] limits) {
		this.limits = limits;
	}

	void setLimis(int a0, int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11,
			int a12, int a13) {
		this.limits[0] = a0;
		this.limits[1] = a1;
		this.limits[2] = a2;
		this.limits[3] = a3;
		this.limits[4] = a4;
		this.limits[5] = a5;
		this.limits[6] = a6;
		this.limits[7] = a7;
		this.limits[8] = a8;
		this.limits[9] = a9;
		this.limits[10] = a10;
		this.limits[11] = a11;
		this.limits[12] = a12;
		this.limits[13] = a13;

	}
	
	Boolean canIWork(int shift){
		return this.limits[shift]==0;
	}
}
