package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class commonUtils {
	
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	
	public static final int PAGE_LOAD_TIME = 15;
	
	public static final int EXPLICIT_WAIT_BASIC_TIME = 15;
	
	public String generateUniqueEmail() {
		
		String baseEmail = "prakash@gmail.com";
		
		// Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define the format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        // Format the current date and time
        String formattedDateTime = currentDateTime.format(formatter);
        // Split the base email to get the name and domain parts
        String[] emailParts = baseEmail.split("@");
		
        // Create the unique email by inserting the formatted date and time into the base email
        String uniqueEmail = emailParts[0] + "+" + formattedDateTime + "@" + emailParts[1];
        
        return uniqueEmail;
		
	}

}
