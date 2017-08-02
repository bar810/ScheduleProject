package presenter;

import java.io.IOException;

import model.Model;
import view.View;

public class newWorker implements Command {
	private View v;
	private Model m;

	public newWorker(View view, Model model) {
		this.v = view;
		this.m = model;
	}

	@Override
	public void doCommand(String[] args) {
		try {
			m.newWorker(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}