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
public class FindNumbersMenu extends JMenuItem implements ActionListener {

    private PhoneBook phoneBook;
    private PhoneBookGUI gui;

    public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
        super("Find numbers");
        this.phoneBook = phoneBook;
        this.gui = gui;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter name");
        List<String> numbers = phoneBook.findNumber(name);
        gui.clearMessages();
        if (numbers != null) gui.appendPerson(name, numbers);
    }
}
