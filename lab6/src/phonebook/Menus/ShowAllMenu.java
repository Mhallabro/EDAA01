package phonebook.Menus;

import phonebook.PhoneBook;
import phonebook.PhoneBookGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

/**
 * Created by dat12jsc on 12/12/14.
 */
public class ShowAllMenu extends JMenuItem implements ActionListener {

    private PhoneBook phoneBook;
    private PhoneBookGUI gui;

    public ShowAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
        super("Show all");
        this.phoneBook = phoneBook;
        this.gui = gui;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Set<String> names = phoneBook.names();
        gui.clearMessages();
        for (String name : names) {
            gui.appendPerson(name, phoneBook.findNumber(name));
        }
    }
}
