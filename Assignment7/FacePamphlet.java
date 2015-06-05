/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {
	/* Instance Variables */
	// NORTH
	private JTextField name;
	private JButton add;
	private JButton delete;
	private JButton lookup;
	
	// WEST
	private JTextField status;
	private JButton changeStatus;
	private JTextField picture;
	private JButton changePicture;
	private JTextField friend;
	private JButton addFriend;
	
	// Other
	private FacePamphletDatabase facePamphletDB;
	private FacePamphletProfile currentProfile = null;
	private FacePamphletCanvas canvas;

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		// You fill this in
		// NORTH Interactors
		JLabel label = new JLabel("Name: ");
		add(label, NORTH);
		
		name = new JTextField(TEXT_FIELD_SIZE);
		add(name, NORTH);
		
		add = new JButton("Add");
		add(add, NORTH);
		
		delete = new JButton("Delete");
		add(delete, NORTH);
		
		lookup = new JButton("Lookup");
		add(lookup, NORTH);
		
		// WEST Interactors
		status = new JTextField(TEXT_FIELD_SIZE);
		status.addActionListener(this);
		add(status, WEST);
		
		changeStatus = new JButton("Change Status");
		add(changeStatus, WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		picture = new JTextField(TEXT_FIELD_SIZE);
		add(picture, WEST);
		picture.addActionListener(this);
		
		changePicture = new JButton("Change Picture");
		add(changePicture, WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		friend = new JTextField(TEXT_FIELD_SIZE);
		add(friend, WEST);
		friend.addActionListener(this);
		
		addFriend = new JButton("Add Friend");
		add(addFriend, WEST);
		
		canvas = new FacePamphletCanvas();
		add(canvas);
		
		addActionListeners();
		
		facePamphletDB = new FacePamphletDatabase();
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
    	String enteredName = name.getText();
    	
    	if (e.getSource() == add && enteredName != "") {
    		if (!facePamphletDB.containsProfile(enteredName)) {
    			FacePamphletProfile profile = new FacePamphletProfile(enteredName);
    			facePamphletDB.addProfile(profile);
    			canvas.displayProfile(profile);
    			canvas.showMessage("New Profile Created!");
    			currentProfile = profile;
    		} else {
    			canvas.showMessage("Profile for " + enteredName + " already exists.");
    			currentProfile = facePamphletDB.getProfile(enteredName);
    		}
    	} else if (e.getSource() == delete && enteredName != "") {
    		if (facePamphletDB.containsProfile(enteredName)) {
    			facePamphletDB.deleteProfile(enteredName);
    			canvas.showMessage("Delete: profile of " + enteredName + " deleted.");
    		} else {
    			canvas.showMessage("Delete: profile with name " + enteredName + " does not exist.");
    		}
    		
    		currentProfile = null;
    	} else if (e.getSource() == lookup && enteredName != "") {
    		canvas.removeAll();
    		
    		if (facePamphletDB.containsProfile(enteredName)) {
    			FacePamphletProfile profile = facePamphletDB.getProfile(enteredName);
    			canvas.displayProfile(profile);
    			canvas.showMessage("Lookup: " + profile.toString());
    			currentProfile = facePamphletDB.getProfile(enteredName);
    		} else {
    			canvas.showMessage("Lookup: profile with " + enteredName + " does not exist.");
    			currentProfile = null;
    		}
    	} else if (e.getSource() == status || e.getSource() == changeStatus) {
    		String enteredStatus = status.getText();
    		
    		if (currentProfile != null) {
    			currentProfile.setStatus(enteredStatus);
    			FacePamphletProfile profile = facePamphletDB.getProfile(currentProfile.getName());
    			canvas.displayProfile(profile);
    			canvas.showMessage("Status updated to: " + enteredStatus);
    		} else {
    			canvas.showMessage("Select a profile to change the status.");
    		}
    	} else if ((e.getSource() == picture || e.getSource() == changePicture) && picture.getText() != "") {
    		String enteredPicture = picture.getText();
    		
    		if (currentProfile != null) {
    			GImage image = null;
        		
        		try {
        			image = new GImage(enteredPicture);
        		} catch (ErrorException ex) {
        			
        		}
        		
        		if (image != null) {
        			currentProfile.setImage(image);
        			canvas.displayProfile(currentProfile);
        			canvas.showMessage("You updated your profile picture.");
        		} else {
        			canvas.showMessage("Unable to open file.");
        		}
    		} else {
    			println("Select a profile to update profile picture.");
    		}
    	} else if ((e.getSource() == friend || e.getSource() == addFriend) && friend.getText() != "") {
    		String enteredFriend = friend.getText();
    		
    		if (currentProfile != null) {
    			FacePamphletProfile friendsProfile = facePamphletDB.getProfile(enteredFriend);
    			
    			if (friendsProfile != null) {
    				if (friendsProfile == currentProfile) {
    					canvas.showMessage("You cannot add yourself as a friend.");
    				} else if (currentProfile.addFriend(friendsProfile.getName())) {
    					friendsProfile.addFriend(currentProfile.getName());
    					canvas.displayProfile(currentProfile);
    					canvas.showMessage("You added " + friendsProfile.getName() + " as a friend.");
    				} else {
    					canvas.showMessage("You already have " + friendsProfile.getName() + " as a friend.");
    				}
    			}
    		} else {
    			canvas.showMessage("Select a profile before adding friends.");
    		}
    	}
	}
}
