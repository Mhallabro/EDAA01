package phonebook.Menus;

import phonebook.PhoneBook;
import phonebook.PhoneBookGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by dat12jsc on 12/12/14.
 */
public class FindNamesMenu extends JMenuItem implements ActionListener {

    private PhoneBook phoneBook;
    private PhoneBookGUI gui;

    public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
        super("Find names");
        this.phoneBook = phoneBook;
        this.gui = gui;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String number = JOptionPane.showInputDialog("Enter number");
        List<String> names = phoneBook.findNames(number);
        gui.appendPerson(number, names);
    }
}
