package giit.carl.page;

public class PageFactory implements Factory {

	@Override
	public Page buildMainPage() {

		StringBuilder body = new StringBuilder();
		body.append("\n\t 1. Login");
		body.append("\n\t 2. Sing up");
		body.append("\n\t 3. Exit");
		body.append("\n");
		body.append("\nPlease select one: ");
				
		
		return new MainPage("Menu main", body.toString());
		
	}

	@Override
	public Page buildLoginPage() {
		
		StringBuilder body = new StringBuilder();
		body.append("\nLogowanie");
				
		return new LoginPage("Login Page", body.toString());
	}

	@Override
	public Page buildRegisterPage() {
		
		StringBuilder body = new StringBuilder();
		body.append("\nProszę wypełnić pola.");
				
		return new LoginPage("Register Page", body.toString());
	}
	
	@Override
	public Page buildDesktopPage() {
		
		StringBuilder body = new StringBuilder();
		body.append("\n\t 1. Change email");
		body.append("\n\t 2. Change phone number");
		body.append("\n\t 3. Back");
		body.append("\n");
		body.append("\nPlease select one: ");
				
		return new DesktopPage("Desktop Page", body.toString());
	}	
	
}
