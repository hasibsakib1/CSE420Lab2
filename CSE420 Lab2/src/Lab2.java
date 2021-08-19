/*
 * Name: Hasibul Sakib
 * ID: 19101283
 * Section: 4
 */

import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int n= sc.nextInt();
		sc.nextLine();
		
		System.out.printf("Enter %d email or web address\n",n);
		String[] s= new String[n];
		for(int i=0; i<n; i++) {
			s[i] = sc.nextLine();
		}
		sc.close();
		
		EmailCheck mlc= new EmailCheck();
		WebCheck wbc= new WebCheck();
		
		for(int i=0; i<s.length; i++ ) {
			
			if(mlc.isEmail(s[i])){
				System.out.println("Email, "+ (i+1));
			}
			else if(wbc.isWeb(s[i])) {
				System.out.println("Web, "+ (i+1));
			}
			else {
				System.out.println("Not an email or web address, "+ (i+1));
			}
				
		}
	
	}

}
