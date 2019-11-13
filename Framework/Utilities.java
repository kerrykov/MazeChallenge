package Framework;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * 
 * JL - created
 * JL - implemented confirm(), ask(), inform(), error(), saveChanges(), getFileName(), save(), open(), makeMenu()
 * KK - fixed getFileName()
 *
 */

public class Utilities {

	// Enables stack traces and diagnostics
	public static Boolean DEBUG = true;

	// Asks the user a yes/no question
	public static boolean confirm(String query) {
		int result = JOptionPane.showConfirmDialog(null,
				query, "choose one", JOptionPane.YES_NO_OPTION);
		return result == 1;
	}

	// Asks user for info (String)
	public static String ask(String query) {
		return JOptionPane.showInputDialog(null, query);
	}

	// Tells user some info (String)
	public static void inform(String info) {
		JOptionPane.showMessageDialog(null,info);
	}

	// Tells user lots of info (String[])
	public static void inform(String[] items) {
		String infoString = "";
		for(int i = 0; i < items.length; i++) {
			infoString = infoString + "\n" + items[i];
		}
		inform(infoString);
	}

	// Tells user about an error
	public static void error(String gripe) {
		JOptionPane.showMessageDialog(null, gripe, "OOPS!", JOptionPane.ERROR_MESSAGE);
	}

	// Tells user about an exception
	public static void error(Exception gripe) {
		
		// Prints stack trace 
		if (DEBUG) {
			gripe.printStackTrace();
		}
		
		// Tells the user about the error
		JOptionPane.showMessageDialog(null, gripe.getMessage(), "OOPS!", JOptionPane.ERROR_MESSAGE);
	}

	// Asks user save changes?
	public static void saveChanges(Model model) {
		
		if (model.hasUnsavedChanges() &&
		      Utilities.confirm("current model has unsaved changes, continue?")) {
			Utilities.save(model, false);
		}
	}

	// Ssks user for a file name
	public static String getFileName(String fName, Boolean open) {
		
		JFileChooser chooser = new JFileChooser();
		String result = null;
		
		if (fName != null) {
		   // open chooser in directory of fName
           chooser.setCurrentDirectory(new File(fName));
		}
		
		if (open) {
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				result = chooser.getSelectedFile().getPath();
			}
		} else {
			int returnVal = chooser.showSaveDialog(null);
		}
		return result;
	}

	// Save model
	public static void save(Model model, Boolean saveAs) {
		
		String fName = model.getFileName();
		
		// Save filename of the model
		if (fName == null || saveAs) {
			fName = Utilities.getFileName(fName);
			model.setFileName(fName);
		}
		
		// Attempts to save model using an Output Stream
		try {
			
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
			model.setUnsavedChanges(false);
			
			os.writeObject(model);
			os.close();
			
		} catch (Exception err) {
			
			model.setUnsavedChanges(true);
			Utilities.error(err);
			
		}
	}

	// Open model
	public static Model open(Model model) {
		
		// Saves the current model
		saveChanges(model);
		String fName = Utilities.getFileName(model.getFileName());
		Model newModel = null;
		
		// Attempts to open model using an Input Stream
		try {
			
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
			newModel = (Model)is.readObject();
			is.close();
			
		} catch (Exception err) {
			Utilities.error(err);
		}
		
		return newModel;
	}

	// A simple menu maker
	public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
		
		JMenu result = new JMenu(name);
		
		// Adds items to JMenu
		for(int i = 0; i < items.length; i++) {
			JMenuItem item = new JMenuItem(items[i]);
			item.addActionListener(handler);
			result.add(item);
		}
		
		return result;
	}

}
