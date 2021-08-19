/*
 * Name: Hasibul Sakib
 * ID: 19101283
 * Section: 4
 */

import java.util.Arrays;

public class WebCheck {
	String [] alphabet= {"a", "b", "c", "d","e", "f", "g",
			"h", "i", "j","k", "l", "m","n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x","y", "z"};
	String [] digits= {"0","1","2","3","4","5","6","7","8","9"};
	
	public boolean isWeb(String s) {
		
		s= s.toLowerCase();
		boolean isValid= false;
		int state= 0;
		String[] temp=null;
		String[] currentArray=null;
		if (s.startsWith("http://www.") || s.startsWith("https://www.")|| s.startsWith("www.")) {
			state= 1;
			temp= s.split("www.",2);
			currentArray= temp[1].split("");

			for(int i=0; i<currentArray.length; i++) {
				String curSym= currentArray[i];


				switch(state) {

				case 1:
					if(Arrays.asList(alphabet).contains(curSym)) {
						state = 2;
					}
					else if(Arrays.asList(digits).contains(curSym)) {
						state = 2;
					}
					else {
						state= 0;
					}
					break;

				case 2:
					if(Arrays.asList(alphabet).contains(curSym)) {
						state = 2;
					}
					else if(Arrays.asList(digits).contains(curSym)) {
						state = 2;
					}
					else if(curSym.contains(".")) {
						state = 4;
					}
					else if(curSym.contains("-")) {
						state = 3;
					}
					else {
						state= 0;
					}
					break;
				
				case 3:
					if(Arrays.asList(alphabet).contains(curSym)) {
						state = 2;
					}
					else {
						state = 0;
					}
					break;

				case 4:
					if(Arrays.asList(alphabet).contains(curSym)) {
						isValid = true;
						state = 4;
					}
					else if(curSym.contains(".")) {
						state= 5;
					}
					else {
						state= 0;
					}
					break;

				case 5:
					if(Arrays.asList(alphabet).contains(curSym)) {
						state= 5;
						isValid= true;
					}
					else {
						state= 0;
					}
					break;
				}
				
				if(state == 0) {
					isValid= false;
					break;
				} //considering 0 as trap state
				
				//System.out.println(state);

			}
		}

		
		return isValid;
	}
}
