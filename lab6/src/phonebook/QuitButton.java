package phonebook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream("phonebook.dat"));
			out.writeObject(this.phoneBook);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		System.exit(1);
	}
}
