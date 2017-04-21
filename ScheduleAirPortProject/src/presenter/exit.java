package presenter;

import model.Model;
import view.View;

public class exit implements Command {
	private View v;
	private Model m;

	public exit(View view, Model model) {
		this.v = view;
		this.m = model;
	}

	@Override
	public void doCommand(String[] args) {

		v.Print("\n Shutdown the program. thank you \n");
	}
}