package presenter;

import model.Model;
import view.View;

public class newSchedule implements Command {
	private View v;
	private Model m;

	public newSchedule(View view, Model model) {
		this.v = view;
		this.m = model;
	}

	
	
	@Override
	public void doCommand(String[] args) {
		m.newSchedule(args[0]);


	}
}