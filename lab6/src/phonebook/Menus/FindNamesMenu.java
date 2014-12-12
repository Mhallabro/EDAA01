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
        if (number == null || number.equals("")) {
            JOptionPane.showMessageDialog(gui, "Please enter a name");
            gui.clearMessages();
            return;
        }
        List<String> names = phoneBook.findNames(number);
        gui.clearMessages();
        if (names != null) gui.appendPerson(number, names);
    }
}
