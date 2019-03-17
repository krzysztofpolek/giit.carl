package giit.carl;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import giit.carl.command.main.CommandExit;
import giit.carl.command.main.CommandLogin;
import giit.carl.command.main.CommandRegister;
import giit.carl.command.main.RemoteConrtol;
import giit.carl.controler.MainControler;
import giit.carl.page.Factory;
import giit.carl.page.PageFactory;

@SpringBootApplication
@ComponentScan(basePackages = "giit.carl")
public class CarlApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(CarlApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		
		while(true) {

			Factory pageFactory = new PageFactory();
			pageFactory.buildMainPage().build();
			
			RemoteConrtol control = new RemoteConrtol();
			MainControler mainMenu = new MainControler();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
				case 1:
					pageFactory.buildLoginPage().build();
					control.setCommand(new CommandLogin(mainMenu));	
					control.press();
					break;
				case 2:
					pageFactory.buildRegisterPage().build();
					control.setCommand(new CommandRegister(mainMenu));		
					control.press();
					break;
				case 3:
					control.setCommand(new CommandExit(mainMenu));
					control.press();
				default:
					System.out.println("\nBłedy wybór. Proszę spróbować jeszcze raz.");
					
			}
			
			
		}

	}
    
}
