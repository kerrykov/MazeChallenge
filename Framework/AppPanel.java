package Framework;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AppPanel extends JPanel implements Observer {
	
	// Variables
	protected Model model;
	protected ActionListener listener;
	protected Set<View> views;
		  
	
	
	// not completely sure how to use this yet.
	// We have an update in the view as well but I'm
	// not sure how the pnel is updated
// UNFINISHED
	public void update(Observable subject, Object msg) {
		// override in a subclass if desired
	}
// UNFINISHED

	
	
	
	  
	// Sets a new model to the AppPanel (and the views)
	public void setModel(Model model) {
		
		// Delete the AppPanel from the observer of the old model
		if (this.model != null) {
			this.model.deleteObserver(this);
		}
		
		// Sets the new model for the AppPanel
		this.model = model;		
		
		// Add the AppPanel to the new model's observer
		if (this.model != null) {
			this.model.addObserver(this);
		}
		
		// For each view, set its model to this model
		for(View view: views) {
			view.setModel(model);
		}
	}
	  
	// Adds view to AppPanel (and JPanel)
	public void add(View view) {
		super.add(view);			// Adds view to JPanel
		views.add(view);
	}
	  
}
