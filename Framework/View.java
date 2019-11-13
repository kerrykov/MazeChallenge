package Framework;

import java.util.*;
import javax.swing.*;

/**
 * 
 * JL - created
 * JL - implemented view(), update(), setModel()
 * JL - improved update()
 *
 */

@SuppressWarnings("serial")
abstract public class View extends JComponent implements Observer {
	
	// Protected Variable
	protected Model model;
	
	// Empty Constructor
	public View() { 
		this(null); 
	}
	
	// Constructor
	public View(Model model) { 
		setModel(model);
	}
	  
	// Updates the maze view
	public void update(Observable subject, Object msg) {
		model = (Model) subject;
		repaint();
	} 
	
	// Sets the model in the view to the new model
	public void setModel(Model model) {
		
		// If there exists a model, delete this observer from the model
		// We then set this view to look at the new model parameter
		if (this.model != null) {
			this.model.deleteObserver(this);
		}
		
		this.model = model;		// Updates the model in the view to the parameter model
     
		// After updating the model of our view, we add the view to the model as an
		// observer. Then, we update ourselves (repaint).
     	if (this.model != null) {
     		this.model.addObserver(this);
     		this.update(model, null); 		// update myself
     	}
  }
}
