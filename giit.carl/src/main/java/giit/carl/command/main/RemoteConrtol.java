package giit.carl.command.main;

public class RemoteConrtol {

	private Command command;

	public void setCommand(Command command) {
		
		this.command = command;
		
	}	
	
	public void press() {

		command.execute();
		
	}
	
}
