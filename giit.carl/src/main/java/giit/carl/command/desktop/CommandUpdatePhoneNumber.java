package giit.carl.command.desktop;

import giit.carl.controler.DesktopControler;

public class CommandUpdatePhoneNumber implements Command {

	DesktopControler desktopMenu;
	String name;

	public CommandUpdatePhoneNumber(DesktopControler desktopMenu, String name) {
		
		this.desktopMenu = desktopMenu;
		this.name = name;
		
	}

	public void execute() {
		
		desktopMenu.updatePhoneNumber(name);
		
	}
	
}
