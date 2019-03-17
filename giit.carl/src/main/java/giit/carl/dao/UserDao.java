package giit.carl.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Component;

import giit.carl.model.User;

@Component
public class UserDao {

	public void create(User user) {
						
		try {
		   	
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./users.txt", true)));
		    out.println(user.getName() + ";" + user.getPassword() + ";" + user.getEmail() + ";" + user.getPhoneNumber());
			out.close();
	
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

	public void updatePhoneNumber(User user, String newPhoneNumber) {
		
		FileWriter fw = null;
		BufferedReader bufferedReader = null;
			
        try {
        	
            FileReader fileReader =  new FileReader("./users.txt");
            bufferedReader = new BufferedReader(fileReader);
            
            String line = "";
            String lineNew = "";
            
            while((line = bufferedReader.readLine()) != null) {
            	
                String[] record = line.split(";");
                
                if(record[0].equals(user.getName())) {
                	
                	line.replace(user.getPhoneNumber(), newPhoneNumber); 
                	
                }
                
                lineNew = lineNew + line + "\n";
                System.out.println(line);
            }   
            
        	fw = new FileWriter("./users.txt");
        	fw.write(lineNew);
            
        }
        catch(FileNotFoundException ex) {
        	
            System.out.println("Nie można znaleźć pliku.");      
            
        }
        catch(IOException ex) {
        	
            System.out.println("Błąd odczytu");
                 
        }				
        finally {
        	
            try {
            	
            	bufferedReader.close();              
                fw.close();
                
            } 
            catch (IOException e) {
            	
                e.printStackTrace();
                
            }
        }   
		
	}
	
	public void updateEmail(User user, String newEmail) {
		
		FileWriter fw = null;
		BufferedReader bufferedReader = null;
			
        try {
        	
            FileReader fileReader =  new FileReader("./users.txt");
            bufferedReader = new BufferedReader(fileReader);
            
            String line = "";
            String lineNew = "";
            
            while((line = bufferedReader.readLine()) != null) {
            	
                String[] record = line.split(";");
                
                if(record[0].equals(user.getName())) {
                	
                	line.replace(user.getEmail(), newEmail);
                	
                }
                
                lineNew = lineNew + line + "\n";
            }   
            
        	fw = new FileWriter("./users.txt");
        	fw.write(lineNew);
            
        }
        catch(FileNotFoundException ex) {
        	
            System.out.println("Nie można znaleźć pliku.");      
            
        }
        catch(IOException ex) {
        	
            System.out.println("Błąd odczytu");
                 
        }				
        finally {
        	
            try {
            	
            	bufferedReader.close();              
                fw.close();
                
            } 
            catch (IOException e) {
            	
                e.printStackTrace();
                
            }
        }   
		
	}

	public boolean checkIfUserExist(String name, String password) {

		boolean exist = false;
		
        try {
        	
            FileReader fileReader =  new FileReader("./users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = "";
            
            while((line = bufferedReader.readLine()) != null) {
            	
                String[] record = line.split(";");
                
                if(record[0].equals(name) && record[1].equals(password)) {
                	
                	exist = true;
                	
                }
                
            }   
            
            if(!exist) {
            	
            	System.out.println("Błedy nazwa użytkownika lub hasło.");
            	
            }
            
            bufferedReader.close();   
            
        }
        catch(FileNotFoundException ex) {
        	
            System.out.println("Nie można znaleźć pliku."); 
              
        }
        catch(IOException ex) {
        	
            System.out.println("Błąd odczytu"); 
            
        }
        
		return exist;
		
	}

	
	public boolean checkIfNameExist(String name) {
	
		boolean exist = false;
		
        try {
        	
            FileReader fileReader =  new FileReader("./users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = "";

            while((line = bufferedReader.readLine()) != null) {
            	
                String[] record = line.split(";");
    
                if(record[0].equals(name)) {
                	
                	System.out.println("Podany użytkownik już istnieje.");
                	
                	exist = true;
                	
                }
                
            }   
            
            bufferedReader.close();  
            
        }
        catch(FileNotFoundException ex) {
        	
            System.out.println("Nie można znaleźć pliku.");   
            
        }
        catch(IOException ex) {
        	
            System.out.println("Błąd odczytu");      
            
        }
        
		return exist;		
		
	}

	public User getUserByName(String name) {
		
		User user = new User();
		
        try {
        	
            FileReader fileReader =  new FileReader("./users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = "";
            
            while((line = bufferedReader.readLine()) != null) {
            	
                String[] record = line.split(";");
                
                if(record[0].equals(name)) {
                	
                	user.setName(record[0]);
                	user.setPassword(record[1]);
                	user.setEmail(record[2]);
                	user.setPhoneNumber(record[3]);
                	
                }
                
            }   
            
            bufferedReader.close();   
            
        }
        catch(FileNotFoundException ex) {
        	
            System.out.println("Nie można znaleźć pliku."); 
            
        }
        catch(IOException ex) {
        	
            System.out.println("Błąd odczytu");      
            
        }
        
		return user;
		
	}
	
}
