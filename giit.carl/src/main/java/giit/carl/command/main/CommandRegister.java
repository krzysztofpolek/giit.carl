package giit.carl.command.main;

import giit.carl.controler.MainControler;

public class CommandRegister implements Command {

	MainControler mainMenu;
	
	public CommandRegister(MainControler mainMenu) {

		this.mainMenu = mainMenu;
		
	}

	@Override
	public void execute() {

		mainMenu.register();
		
	}

}
