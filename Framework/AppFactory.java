package Framework;

import java.awt.event.*;

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
