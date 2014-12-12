package phonebook;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
	public static void main(String[] args) {
		PhoneBook pb = deserialize();
		new PhoneBookGUI(pb);
	}

	public static PhoneBook deserialize() {
		PhoneBook pb;
		try {
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("phonebook.dat"));
			pb = (PhoneBook) in.readObject();
		} catch (Exception e) {
			pb = new PhoneBook();
		}
		return pb;
	}

}
