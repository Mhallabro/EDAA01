package phonebook.Menus;

import phonebook.PhoneBook;
import phonebook.PhoneBookGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = JOptionPane.showInputDialog("Enter name");
		 if (name != null) {
			 phoneBook.remove(name);
		 } else {
			 JOptionPane.showMessageDialog(gui, "Name cannot be null!");
		 }
	 }
}
