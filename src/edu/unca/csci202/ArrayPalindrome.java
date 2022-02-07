package edu.unca.csci202;

public class ArrayPalindrome {

	ArrayStack<String> stack1 = new ArrayStack<String>();
	ArrayStack<String> stack2 = new ArrayStack<String>();
	ArrayStack<String> stack3 = new ArrayStack<String>();

	public boolean isPalindrome(String testPalindrome) throws EmptyCollectionException{
		
		for (int i = 0; i < testPalindrome.length(); i++) {
			
			if (Character.toString(testPalindrome.charAt(i)).isEmpty()) {
				
				throw new EmptyCollectionException(testPalindrome);
			}
			
			String letter = Character.toString(testPalindrome.charAt(i));
			
			if (letter.isBlank()) {
				
				throw new EmptyCollectionException("stack");
			}
			stack1.push(letter);
			stack2.push(letter);
		}
		
		if (stack1.size() == 0) {
			
			throw new EmptyCollectionException(stack1.toString());
		}
		
		for (int i = 0; i < testPalindrome.length(); i++) {
			
			stack3.push(stack2.pop());
		}
		
		while (!stack1.isEmpty()) {
			
			for (int i = 0; i < testPalindrome.length(); i++) {
				
				String x = stack1.pop();
				String y = stack3.pop();
				
				if (x.equals(y)) {
					
					continue;
				} else {
								
					System.out.println(testPalindrome + " is not a palindrome.");
					clear(testPalindrome.length());
					return false;
				}
			}
		}
		
		System.out.println(testPalindrome + " is a palindrome.");
		clear(testPalindrome.length());
		return true;
	}
	
	public void clear(int palLength) {
		
		try {
			for (int i = 0; i < palLength; i++) {
				
				stack1.pop();
				stack3.pop();
			}
		} catch (EmptyCollectionException e) {
			
		}
		
	}
}
