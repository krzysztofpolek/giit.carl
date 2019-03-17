package giit.carl.validate;

import java.util.Random;

public class Validate {
	
	public boolean checkLenName(String name) {
		
		if(name.length() >= 3) {
			
			return true;
					
		}
		else {
			
			System.out.println("Nazwa użytkownika musi mieć min 3 znaki.");
			
			return false;
			
		}
		
	}

    public boolean chechEmailAddress(String email) {
    	
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        
        if(!m.matches()) {
        	
        	System.out.println("Podany email jest błędny.");
        	
        }
        
        return m.matches();
        
    }
    
	public boolean checkValidationPassword(String pass) {
		
		boolean check = false;
		
		int x = 0, y = 0, z = 0;
		
		if(pass.length() > 7) {
			
			for (int i = 0; i < pass.length(); i++) {
				
				if(Character.isUpperCase(pass.charAt(i))) {
					x = 1;
				}
				
				if(Character.isDigit(pass.charAt(i))) {
					y = 1;
				}			
				
				if(!Character.isDigit(pass.charAt(i)) && !Character.isLetter(pass.charAt(i)) && !Character.isSpace(pass.charAt(i))) {
					z = 1;	
				}					
				
			}
			
			if (x > 0 && y > 0 && z > 0) {
				
				check = true;
				
			}
			
		}
		
		if(!check) {
			
			System.out.println("Hasło nie spełnia jedngo z parametrów: min. 8 znaków, w tym 1 duża litera, 1 znak specjalny, 1 cyfra");
			
		}
		
		return check;
		
	}
	
	public String generatePassword() {
		
        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "!@#$%^&*()_+-=.,/';:?><~*/-+";	
        String all = charsCaps + chars + nums + symbols;
        
        char[] charsCapsArray = charsCaps.toCharArray();
        char[] charsArray = chars.toCharArray();
        char[] numsArray = nums.toCharArray();
        char[] symbolsArray = symbols.toCharArray();
        char[] allArray = all.toCharArray();
        
        Random r = new Random();
        
        StringBuilder sb = new StringBuilder();
        sb.append(charsCapsArray[r.nextInt(charsCapsArray.length)]);
        sb.append(charsArray[r.nextInt(charsArray.length)]);
        sb.append(numsArray[r.nextInt(numsArray.length)]);
        sb.append(symbolsArray[r.nextInt(symbolsArray.length)]);
        
        for (int i = 0; i < 4; i++) {
        	
        	sb.append(allArray[r.nextInt(allArray.length)]);
        	
        }
        
        return sb.toString();
        
	}	
	
}
