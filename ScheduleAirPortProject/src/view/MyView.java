package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class MyView extends Observable implements View, Observer {
	CLI cli;
	private BufferedReader reader;
	private PrintWriter writer;

	public MyView(BufferedReader reader, PrintWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
		cli = new CLI(reader, writer);
		cli.addObserver(this);
	}

	@Override
	public void start() throws Exception {
		Thread cliThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cli.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		cliThread.run();
	}

	@Override
	public void Print(String str) {
		writer.write(str);
		writer.flush();
	}

	@Override
	public void displayMessage(String msg) {
		writer.println(msg);
		writer.flush();

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0 == cli) {
			this.setChanged();
			this.notifyObservers(arg1);
		}

	}

}
