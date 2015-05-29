import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// get input
		Scanner sc = new Scanner(System.in);
		String encrypted = sc.nextLine();

		// slice and switch
		String slicedAndSwitched = encrypted.substring(
				(int) Math.round(encrypted.length() / 2.0), encrypted.length())
				+ encrypted.substring(0,
						(int) Math.round(encrypted.length() / 2.0));

		// get alphabet length
		String alphabetCountString = "";
		for (int i = 0; i < slicedAndSwitched.length(); i++) {
			if (Character.isDigit(slicedAndSwitched.charAt(i))) {
				alphabetCountString += slicedAndSwitched.charAt(i);
			} else {
				break;
			}
		}

		int alphabetCount = Integer.parseInt(alphabetCountString);

		// get alphabet
		String alphabet = slicedAndSwitched.substring(
				alphabetCountString.length() + 1, alphabetCountString.length()
						+ 1 + alphabetCount);

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

		int keyCount = Integer.parseInt(keyCountString);

		// get key
		String key = slicedAndSwitched.substring(slicedAndSwitched.length() - 1
				- keyCountString.length() - keyCount,
				slicedAndSwitched.length() - 1 - keyCountString.length());

		// get encrypted message
		String encryptedMessage = slicedAndSwitched.substring(
				alphabetCountString.length() + 1 + alphabet.length(),
				slicedAndSwitched.length() - 1 - keyCountString.length()
						- key.length());

		// make key the length of the message
		int timesToAdd = (int) Math.ceil((double) encryptedMessage.length()
				/ (double) key.length()) - 1;
		String saveKey = key;
		for (int i = 0; i < timesToAdd; i++) {
			key += saveKey;
		}

		key = key.substring(0, encryptedMessage.length());

		// remove each key index from each encrypted message index
		int[] originalMessageIndexes = new int[encryptedMessage.length()];
		int index = 0;
		for (int i = 0; i < encryptedMessage.length(); i++) {
			index = alphabet.indexOf(encryptedMessage.charAt(i))
					- alphabet.indexOf(key.charAt(i));
			if (index < 0) {
				index = index + alphabet.length();
			}

			originalMessageIndexes[i] = index;
		}

		// get original message
		for (int i = 0; i < originalMessageIndexes.length; i++) {
			System.out.print(alphabet.charAt(originalMessageIndexes[i]));
		}
		
		sc.close();
	}

}
