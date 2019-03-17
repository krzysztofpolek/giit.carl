package giit.carl.command.desktop;

import giit.carl.controler.DesktopControler;

public class CommandUpdateEmail implements Command {

	DesktopControler desktopMenu;
	
	String name;

	public CommandUpdateEmail(DesktopControler desktopMenu, String name) {
		
		this.desktopMenu = desktopMenu;
		this.name = name;
		
	}

	public void execute() {
		
		desktopMenu.updateEmail(name);
		
	}
	
}
