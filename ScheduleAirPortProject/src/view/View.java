package view;

import Entities.Schedule;

/**
 * view interface- all the view's classes will implements this class and
 * override those functions
 * 
 * @author bar brownshtein
 *
 */
public interface View {
	public void start() throws Exception;

	public void Print(String str);

	public void displayMessage(String msg);


}
