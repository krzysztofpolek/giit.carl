package giit.carl.command.main;

import giit.carl.controler.MainControler;

public class CommandLogin implements Command {

	MainControler mianMenu;

	public CommandLogin(MainControler mianMenu) {
		
		this.mianMenu = mianMenu;
		
	}

	public void execute() {
		
		mianMenu.login();
		
	}
	
}
