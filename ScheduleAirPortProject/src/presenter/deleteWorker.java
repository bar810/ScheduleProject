package presenter;

import model.Model;
import view.View;

public class deleteWorker  implements Command {
	private View v;
	private Model m;

	public deleteWorker(View view, Model model) {
		this.v = view;
		this.m = model;
	}



	@Override
	public void doCommand(String[] args) {
m.deleteWorker();		
	}
}

