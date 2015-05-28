
public class Solution {

	public static void main(String[] args) {
		// TODO get input
		String encrypted = "vrItommseIal vihack~416~Ilocveakgrithms he";
		
		// slice and switch
		String slicedAndSwitched = encrypted.substring((int)Math.round(encrypted.length()/2.0), encrypted.length())
				+ encrypted.substring(0, (int)Math.round(encrypted.length()/2.0));
		
		System.out.println(slicedAndSwitched);		
				
		// TODO get alphabet, key and encrypted message
		
		// TODO make key the length of the message
		
		// TODO remove each key index from each encrypted message index
		
		// TODO if negative, add length of the alphabet
		
		// TODO get original message 
	}

}
