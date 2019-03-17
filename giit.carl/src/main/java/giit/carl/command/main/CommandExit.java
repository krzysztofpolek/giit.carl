package giit.carl.command.main;

import giit.carl.controler.MainControler;

public class CommandExit implements Command {

	MainControler mainMenu;
	
	public CommandExit(MainControler mainMenu) {

		this.mainMenu = mainMenu;
		
	}

	public void execute() {
		
		mainMenu.exit();
		
	}

}
