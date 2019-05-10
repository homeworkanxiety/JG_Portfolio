//Title: Caesar Encyrption Algorithim
//Author: John Gallagher
//Purpose: Recreate the caeser-cipher from UDEMY course titled "Learn Cryptography Basic".

//Class for the ALPHABET key 
class Constants {
	
	private Constants(){

	}
	public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int KEY = 3;
}


public class CaesarCipher {


	//Encryption Method
	public String encrypt(String plainText) {

		String cipherText = "";

		//Make the algorithim case insensitive
 		plainText = plainText.toUpperCase();

		//Consider all the letters in the plainText
		for (int i = 0; i <plainText.length(); i++) {
	
			//Find the character for the plaintext letter
			char character = plainText.charAt(i);
			
			//find the numerical reprsentation (index) associated with that character in the alphabet
			int charIndex = Constants.ALPHABET.indexOf(character);
			
			//caesar encryption is just a simple shift of characters according to the key
			//use modular arithmetic to transform the values within the range [0,num_of_letters_in_alphabet]
			//charIndex + Constants.KEY will transform the plaintext letter, and the Constants.ALPHABET.Lenth() is the modular so we don't go over the alphabet number (which is anything above 26-1);
			int encryptedIndex = Math.floorMod(charIndex + Constants.KEY, Constants.ALPHABET.length());

			//keep appending the encrypted character ot the cipher_text
			cipherText = cipherText + Constants.ALPHABET.charAt(encryptedIndex);

		}
		return cipherText;
	}

	//Decryption Method
	public String decrypt(String secretText) {
		
		String decryptedText = "";
		
		for (int i = 0; i <secretText.length(); i++){
		
			char character = secretText.charAt(i);

			int charIndex = Constants.ALPHABET.indexOf(character);

			//this part uses a subtraction operator, the encryption has an addition operator
			int decryptIndex = Math.floorMod(charIndex - Constants.KEY, Constants.ALPHABET.length());

			decryptedText = decryptedText + Constants.ALPHABET.charAt(decryptIndex);
	
		}
		return decryptedText;
	}

	public void crack(String cipherText) {
	
		//we try all the possible key values so the size of the ALPHABET
		//thats why caesar cipher is weak: 26 possible encryptions

		for (int key = 0; key<Constants.ALPHABET.length(); key++) {
			//reinitialize this to be an empty string
			String plainText = "";

			//we just have to make a simple Caesar decryption 
			for (int i = 0; i <cipherText.length(); i++) {
				char character = cipherText.charAt(i);
				int charIndex = Constants.ALPHABET.indexOf(character);
				int decryptedIndex = Math.floorMod(charIndex-key, Constants.ALPHABET.length());
				plainText = plainText + Constants.ALPHABET.charAt(decryptedIndex);
			}
		System.out.format("Cracking Caeser-Cipher with %s key the result is %s%n",key, plainText);
		}	
	}

	//Main Method
	public static void main(String[] args) {
	CaesarCipher cipher = new CaesarCipher();
	String cipherText = cipher.encrypt("hello");
	String decryptedText = cipher.decrypt(cipherText);


	System.out.print(cipherText + "\n \n");
	System.out.print(decryptedText + "\n  \n ");


	CrackCaesar caesarCrack = new CrackCaesar();
	caesarCrack.crack(cipherText); 
	}
}

//Notes: Be able to answer why we use floor.mod in JAVA. Why not just use the modulus %.
//It's because the modulus operator can't take into account negative nubmers.