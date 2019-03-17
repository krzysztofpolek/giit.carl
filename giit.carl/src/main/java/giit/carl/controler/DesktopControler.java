package giit.carl.controler;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import giit.carl.dao.UserDao;
import giit.carl.model.User;
import giit.carl.validate.Validate;

@Controller
public class DesktopControler {
	
	public void updateEmail(String name) {

		Scanner scanner = new Scanner(System.in);
		
		UserDao userDao = new UserDao();
		
		Validate validate = new Validate();
		
		String email = "";
		
		do {
        	
			System.out.print("\n\nPodaj nowy adres email: ");

			email = scanner.nextLine();
            
        } while (!validate.chechEmailAddress(email));

		userDao.updateEmail(userDao.getUserByName(name), email);
		
	}
	
	public void updatePhoneNumber(String name) {
		
		Scanner scanner = new Scanner(System.in);
		
		UserDao userDao = new UserDao();

		System.out.print("\n\nPodaj nowy numer telefonu: ");

		String phone  = scanner.nextLine();
            
		userDao.updatePhoneNumber(userDao.getUserByName(name), phone);
		
	}
	
}
