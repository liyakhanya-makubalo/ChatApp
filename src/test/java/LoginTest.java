/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.chatapp.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;  

/**
 *
 * @author Student
 */
public class LoginTest {
    
    Login login = new Login();
   
   
   @Test
   public void testValidUsername(){
       
       assertTrue(login.checkUserName("kyl_1"));
   }
   @Test
   public void testInvalidUsername_WithNoUnderscore(){
       
       assertFalse(login.checkUserName("kyle!!!!!!!"));
   }
   
   
   @Test
   public void testInvalidUserName_TooLong(){ 
       
       assertFalse(login.checkUserName("kyle!!!!!!!"));
   }
   @Test
   public void testValidPassword(){
       
       assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
       
   }
   
   @Test
   public void testInvalidPassword_WithNoCapital(){
       assertFalse(login.checkPasswordComplexity("password"));
   }
   @Test
   public void testInvalidPassword_WithLessNoSpecial(){
       
       assertFalse(login.checkPasswordComplexity("password"));
   }
   @Test
   public void testInvalidPassword_WithLessThan8Characters(){
       
       assertFalse(login.checkPasswordComplexity("password"));
   }
   
   @Test
   public void testValidPhoneNumber(){
       
       assertTrue(login.checkCellPhoneNumber("+27838968976"));
   }
   @Test
   public void testInvalidPhoneNumber_WithNoSACode(){
       
       assertFalse(login.checkCellPhoneNumber("08966553"));
   }
   @Test
   public void testInvalidPhoneNumber_WithLongPhoneNumber(){
       
       assertFalse(login.checkCellPhoneNumber("08366553"));
   }
   
}
