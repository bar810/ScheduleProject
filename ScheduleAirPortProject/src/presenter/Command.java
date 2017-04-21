package presenter;

/**
 * Command interface each class who implements this interface will need to
 * override the function doCommand those classes will override the function in
 * different way, based on them target.
 * 
 * @author bar brownshtein
 * @param string[]
 * 
 *
 */
public interface Command {
	void doCommand(String[] args);
}
