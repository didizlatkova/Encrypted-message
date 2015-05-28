public class Solution {

	public static void main(String[] args) {
		// TODO get input
		String encrypted = "vrItommseIal vihack~416~Ilocveakgrithms he";

		// slice and switch
		String slicedAndSwitched = encrypted.substring(
				(int) Math.round(encrypted.length() / 2.0), encrypted.length())
				+ encrypted.substring(0,
						(int) Math.round(encrypted.length() / 2.0));

		System.out.println(slicedAndSwitched);

		// get alphabet length
		String alphabetCountString = "";
		for (int i = 0; i < slicedAndSwitched.length(); i++) {
			if (Character.isDigit(slicedAndSwitched.charAt(i))) {
				alphabetCountString += slicedAndSwitched.charAt(i);
			} else {
				break;
			}
		}
		System.out.println(alphabetCountString);

		int alphabetCount = Integer.parseInt(alphabetCountString);

		// get alphabet
		String alphabet = slicedAndSwitched.substring(
				alphabetCountString.length() + 1, alphabetCountString.length()
						+ 1 + alphabetCount);
		System.out.println("[" + alphabet + "]");

		// get key
		String keyCountString = "";
		for (int i = slicedAndSwitched.length() - 1; i >= 0; i--) {
			if (Character.isDigit(slicedAndSwitched.charAt(i))) {
				keyCountString += slicedAndSwitched.charAt(i);
			} else {
				break;
			}
		}

		keyCountString = new StringBuilder(keyCountString).reverse().toString();
		System.out.println(keyCountString);

		int keyCount = Integer.parseInt(keyCountString);

		// get key
		String key = slicedAndSwitched.substring(slicedAndSwitched.length() - 1
				- keyCountString.length() - keyCount,
				slicedAndSwitched.length() - 1 - keyCountString.length());
		System.out.println("[" + key + "]");

		// get encrypted message
		String encryptedMessage = slicedAndSwitched.substring(
				alphabetCountString.length() + 1 + alphabet.length(),
				slicedAndSwitched.length() - 1 - keyCountString.length()
						- key.length());
		
		System.out.println("[" + encryptedMessage + "]");

		// TODO make key the length of the message

		// TODO remove each key index from each encrypted message index

		// TODO if negative, add length of the alphabet

		// TODO get original message
	}

}
