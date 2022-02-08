package edu.unca.csci202;

/**
 * Allows the testing of strings to determine whether they're palindromes or not by pushing
 * each character into a stack and then comparing them by popping one by one.
 * 
 * @author Taylor Van Aken
 */
public class ArrayPalindrome {

	private ArrayStack<String> stack1;
	private ArrayStack<String> stack2;
	private ArrayStack<String> stack3;
	
	/**
	 * Creates an instance of ArrayPalindrome and tests strings within the isPalindrome method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayPalindrome test = new ArrayPalindrome();
		test.isPalindrome("mom");
		test.isPalindrome("racecar");
		test.isPalindrome("Racecar");
		test.isPalindrome("racEcar");
	}
	
	/**
	 * Sets up the test environment by creating three new stacks.
	 */
	public ArrayPalindrome() {
		
		stack1 = new ArrayStack<String>();
		stack2 = new ArrayStack<String>();
		stack3 = new ArrayStack<String>();
	}

	/**
	 * Seperates the characters of specified string into two stacks, then reverses stack2 into stack3
	 * before popping stack1 and stack3 elements and comparing them.
	 * @param testPalindrome the string to be tested for palindromeness
	 * @return true if the string is indeed a palindrome
	 * @throws EmptyCollectionException if stack is empty
	 */
	private boolean isPalindrome(String testPalindrome) throws EmptyCollectionException {
		

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
			
			throw new EmptyCollectionException("stack");
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
				} 
				else {
								
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
	
	/**
	 * Clears the stacks to allow for multiple strings to be tested seperately.
	 * @param palLength length of the string tested last within isPalindrome method
	 */
	private void clear(int palLength) {
		
		try {
			for (int i = 0; i < palLength; i++) {
				
				stack1.pop();
				stack3.pop();
			}
		} 
		catch (EmptyCollectionException e) {
			
		}
		
	}
}
