package Framework;

import java.awt.event.*;
import javax.swing.*;
import Framework.Utilities;

/**
 * 
 * JL - created
 * JL - implemented display(), setModel(), createMenuBar(), actionPerformed()
 * JL - implemented getModel(), getPanel(), getFactory(). Fixed setModel()
 *
 */

@SuppressWarnings("serial")
public class AppFrame extends JFrame implements ActionListener {
	  
	// Variables
	private AppFactory factory;
	private Model model;
	private AppPanel panel;
	  
	// Constructor
	public AppFrame(AppFactory factory) {
		
		// Set Variables
		this.factory = factory;
		model = factory.makeModel();
		panel = factory.makePanel(model, this);
		
		// Create Frame
		getContentPane().add(panel);
		setJMenuBar(createMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(factory.getTitle());  
		setSize(500, 500);
	}
	  
	// Displays AppFrame
	public void display() { 
		this.setVisible(true); 
	}
	  
	// Creates Menu Bar for App Frame
	protected JMenuBar createMenuBar() {
		
		// Creates Menu bar and menus
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File"); 
		JMenu editMenu = new JMenu("Edit");  
		JMenu helpMenu = new JMenu("Help");  
			
		// Making Menus
		Utilities.makeMenu("File", new String[] {"New", "Open", "Save", "SaveAs", "Quit"}, this);
		Utilities.makeMenu("Edit", factory.getEditCommands(), this);
		Utilities.makeMenu("Help", new String[] {"Help", "About"}, this);

		// Adding Menus to Menu Bar
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(helpMenu);
		
	    return bar;
	}

	// Action Listener to execute commands in Utilities
	public void actionPerformed(ActionEvent ae) {
		
		String cmmd = ae.getActionCommand();
	     
		if (cmmd == "Save") {
			Utilities.save(model, false);
			
		} else if (cmmd == "SaveAs") {
			Utilities.save(model, true);
			
		} else if (cmmd == "Open") {
			Model newModel = Utilities.open(model);
	        setModel(newModel);
	        
		} else if (cmmd == "New") {
			Utilities.saveChanges(model);
	        setModel(factory.makeModel());
	        model.setUnsavedChanges(false);
	        
		} else if (cmmd == "Quit") {
			Utilities.saveChanges(model);
	        System.exit(1);
	        
		} else if (cmmd == "About") {
			Utilities.inform(factory.about());
			
		} else if (cmmd == "Help") {
			Utilities.inform(factory.getHelp());
			
		} else {
			Command command = factory.makeEditCommand(model, cmmd);
			CommandProcessor.execute(command);
		}
	}

	// Returns model to subclass
	protected Model getModel() {
		return model;
	}
	
	// Returns appPanel to subclass
	protected AppPanel getPanel() {
		return panel;
	}
	
	// Returns appFactory to subclass
	protected AppFactory getFactory() {
		return factory;
	}
	
	// Sets the model of the AppFrame and AppPanel
	// This uses the update component method instead of the copy method
	public void setModel(Model model) {
		  this.model = model;
		  panel.setModel(model);
	}
	
} 
