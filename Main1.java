import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {


		public static void main(String[] args) {
		/*	User user =
					new User("andrzej", "mail", "haslo");

			UserDao userDao = new UserDao();
			User userFromDb = userDao.create(user);

			User user1 = userDao.read(2);

			user1.setUserName("nowe imie");
			userDao.update(user1);

			userDao.delete(23); */

			Group group =
					new Group ("andrzej");

			GrupDao grupDao = new GrupDao();
			Group groupFromDb = grupDao.create(group);

			Group group1 = grupDao.read(2);

			group.setDescryption("nowe imie");
			grupDao.update(group);

			grupDao.delete(22);

	}

}
