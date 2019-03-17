package giit.carl.controler;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import giit.carl.command.desktop.CommandUpdateEmail;
import giit.carl.command.desktop.CommandUpdatePhoneNumber;
import giit.carl.command.desktop.RemoteConrtol;
import giit.carl.dao.UserDao;
import giit.carl.model.User;
import giit.carl.page.Factory;
import giit.carl.page.PageFactory;
import giit.carl.validate.Validate;

@Controller
public class MainControler {
	
	public void login() {
		
		Scanner scanner = new Scanner(System.in);
		
		UserDao userDao = new UserDao();
		
		System.out.print("\n\nPodaj nazwę użytkownika: ");
		
		String name = scanner.next();
		
		System.out.print("Podaj hasło: ");
		
		String password = scanner.next();
		
		if(userDao.checkIfUserExist(name, password)) {
			
			boolean state = true;
			
			while(state) {

				System.out.print("Wellcome, " + name);
				
				Factory pageFactory = new PageFactory();
				pageFactory.buildDesktopPage().build();
				
				RemoteConrtol control = new RemoteConrtol();
				DesktopControler desktopMenu = new DesktopControler();
				
				int choice = scanner.nextInt();
				
				switch(choice) {
					case 1:
						control.setCommand(new CommandUpdateEmail(desktopMenu, name));	
						control.press();
						break;
					case 2:
						control.setCommand(new CommandUpdatePhoneNumber(desktopMenu, name));	
						control.press();
						break; 
					case 3:
						state = false;
						break;						
					default:
						System.out.println("\nBłedy wybór. Proszę spróbować jeszcze raz.");
						
				}	
			
			}			
			
		}
		
	}
	
	public void register() {
		
		Scanner scanner = new Scanner(System.in);
		
		UserDao userDao = new UserDao();
		
		Validate validate = new Validate();
		
		
		String name = "";
		String email = "";
		String pass = "";
		
		do {
			
	        do {
	        	
	        	System.out.print("\n\nPodaj nazwę użytkownika: ");
	
	            name = scanner.nextLine();
	            
	        } while (!validate.checkLenName(name));
	        
		} while(userDao.checkIfNameExist(name));
       
		do {
        	
			System.out.print("\n\nPodaj adres email: ");

			email = scanner.nextLine();
            
        } while (!validate.chechEmailAddress(email));
			
		System.out.print("\n\nPodaj numer telefonu: ");
			
		String phoneNumber = scanner.nextLine();		
		
        do {
        	
        	System.out.print("Podaj hasło (1 - generuj): ");

            pass = scanner.nextLine();
            
			if(pass.equals("1")) {
				
				pass  = validate.generatePassword().toString();
				
				System.out.println("Twoje haslo: " + pass);
				
			}
            
        } while (!validate.checkValidationPassword(pass));
			
        User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(pass);
			
		userDao.create(user);

	}
	
	public void exit() {
	
		Runtime.getRuntime().exit(0);
		
	}
		
}
