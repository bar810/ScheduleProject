package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

public class CLI extends Observable {
	private BufferedReader in;
	private PrintWriter out;

	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	public void start() throws Exception {
		Thread thread = new Thread(new Runnable() {
			String cmd = null;

			@Override
			public void run() {
				do {
					out.write("\nType a Command :\n");
					out.flush();
					try {
						cmd = in.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					setChanged();
					notifyObservers(cmd);

				} while (!(cmd.equals("exit")));
			}
		});
		thread.run();
	}
}
