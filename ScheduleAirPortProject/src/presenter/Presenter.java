package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

/**
 * presenter manages the project and links between the model and the view.
 * 
 * @author bar brownshtein
 */

public class Presenter extends Observable implements Observer {
	private Model model;
	private View view;
	private HashMap<String, Command> commands;

	public Presenter(Model model, View view) {
		this.model = model;
		this.view = view;
		this.set();

	}

	public void set() {
		commands = new HashMap<String, Command>();
		// add commands here:
		commands.put("exit", new exit(view, model));
		;

	}

	@Override
	public void update(Observable o, Object arg) {
		String Cmdstr = (String) arg;
		String[] spliter = Cmdstr.split(" ");
		Command tempCmd = commands.get(spliter[0]);
		if (tempCmd == null) {
			view.Print("Command Not Found!");
		} else {
			tempCmd.doCommand(spliter);
		}
	}
}
