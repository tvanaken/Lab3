package edu.unca.csci202;

public class ArrayPalindrome {

	ArrayStack<String> stack1 = new ArrayStack<String>();
	ArrayStack<String> stack2 = new ArrayStack<String>();
	ArrayStack<String> stack3 = new ArrayStack<String>();

	public boolean isPalindrome(String testPalindrome) {

		for (int i = 0; i < testPalindrome.length(); i++) {
			
			String letter = Character.toString(testPalindrome.charAt(i));
			stack1.push(letter);
			stack2.push(letter);
		}
		
		for (int i = 0; i < testPalindrome.length(); i++) {
			
			stack3.push(stack2.pop());
		}
		
		while (true) {
			
			for (int i = 0; i < testPalindrome.length(); i++) {
				
				if (stack1.pop() == stack3.pop()) {
					
					return true;
				} else {
					
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
}
