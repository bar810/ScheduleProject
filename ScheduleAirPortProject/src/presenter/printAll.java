package presenter;

import model.Model;
import view.View;

public class printAll implements Command {
	private View v;
	private Model m;

	public printAll(View view, Model model) {
		this.v = view;
		this.m = model;
	}

	@Override
	public void doCommand(String[] args) {
		m.printAllWorkers();
	}
}
