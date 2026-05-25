/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

 /**
  * 
  * @author Student
  */
public class Login {
    
    //Enter user details
    //after regestering the user's details will be saved
    String username; 
    String phoneNumber;
    private String password;
    
       
    //the username must be 5 characters long not more tham that
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
        
    }
    
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial =false;
        
 
        for(int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            else if (Character.isDigit(c)) {
                hasNumber = true;
            }
            else if (!Character.isLetterOrDigit(c)){
                hasSpecial = true;
                 
        }
     
    }
         return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;

}
    
    public boolean checkCellPhoneNumber(String phone) {
         return phone.startsWith("+27") && phone.length() <= 12;
}

   public String registerUser(String username,String password,String phoneNumber) {
       
       if(!checkUserName(username)){
          return"Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.";
       }
       

if(!checkPasswordComplexity(password)){
return "Password is not crrectly formatted;please ensure that the password contains at least eight characters,a capital letter,a number,and a special character."; 
}



if(!checkCellPhoneNumber(phoneNumber)) {
    return"Cell phone number incorrectly formatted or does not contain international code.";
}
   
    
 this.username=username;
 this.password=password;
 this.phoneNumber=phoneNumber;
 

return "User registered successfully.";
   }  
    
    
 
public boolean loginUser(String username, String password) {
    return this.username.equals(username) && this.password.equals(password);
}
    
public String returnLoginStatus(boolean success){
    if(success) {
        return "Welcome" + username + " it is great to see you agin.";
    }else{
        return "Username or password incorrect, please try again";
    }
}

    boolean loginUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

    

