package Framework;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
abstract public class Model extends Observable implements Serializable {
	  
	// Variable(s)
	private String fileName = null;
	private Boolean unsavedChanges = false;
	  
	  // Set changes in the model
	public void changed() {
		setUnsavedChanges(true);
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}

	// Get fileName
	public String getFileName() {
		return fileName;
	}

	// Set fileName
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// Get unsavedChanges
	public Boolean hasUnsavedChanges() {
		return unsavedChanges;
	}

	// Set unsavedChanges
	public void setUnsavedChanges(Boolean unsavedChanges) {
		this.unsavedChanges = unsavedChanges;
	}

}