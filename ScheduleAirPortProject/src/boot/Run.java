package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.MyModel;
import presenter.Presenter;
import view.MyView;

/**
 * This class is running the project
 * 
 * @author bar brownshtein
 *
 */
public class Run {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		MyModel model = null;
		MyView view = null;

		model = new MyModel();

		view = new MyView(in, out);
		Presenter presenter1 = new Presenter(model, view);
		view.addObserver(presenter1);
		model.addObserver(presenter1);
		view.start();

	}

}
