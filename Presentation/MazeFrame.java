package Presentation;

import java.awt.event.*;
import Business.*;
import Framework.*;

/**
 * 
 * KK - created
 * JL - implemented MazeFrame(), actionPerformed(), main()
 *
 */

public class MazeFrame extends AppFrame {
		
	// Constructor
	public MazeFrame(AppFactory factory) {
		super(factory);		
	}

	Model model;		// Used to set model in AppFrame
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String cmmd = ae.getActionCommand();
	
		if (cmmd == "Save") {
			Utilities.save(getModel(), false);
				
		} else if (cmmd == "SaveAs") {
			Utilities.save(getModel(), true);
				
		} else if (cmmd == "Open") {
			model = (Maze) Utilities.open(getModel());
			setModel(model);
			getPanel().setModel(getModel());
				
		} else if (cmmd == "New") {
			Utilities.saveChanges(getModel());
			model = new Maze();
			setModel(model);
			getPanel().setModel(getModel());
				
		} else if (cmmd == "Quit") {
			Utilities.saveChanges(getModel());
			System.exit(1);
				
		} else if (cmmd == "Help") {
			Utilities.inform(getFactory().getHelp());
			
		} else if (cmmd == "About") {
			Utilities.inform(getFactory().about());
			
		} else {
			Utilities.error("Command does not exist: " + cmmd);
			
		}
	}
	
	// Creates MazeFrame
	public static void main(String[] args) {
		MazeFactory factory = new MazeFactory();
		MazeFrame mazeFrame = new MazeFrame(factory);
		mazeFrame.setVisible(true);
	}

}

