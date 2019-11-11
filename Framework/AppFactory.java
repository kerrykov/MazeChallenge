package Framework;

import java.awt.event.*;

/**
 * 
 * JL - created
 * JL - implemented make model/panel, get commands, get info
 *
 */

public interface AppFactory {
	
	// Make model and panel
	public Model makeModel();
	public AppPanel makePanel(Model model, ActionListener listener);
	
	// Get Commands
	public String[] getEditCommands();
	public Command makeEditCommand(Model model, String type);
	
	// Get Information 
	public String getTitle();
	public String[] getHelp();
	public String about();
	
}
