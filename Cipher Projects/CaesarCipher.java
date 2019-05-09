//Title: Caesar Encyrption Algorithim
//Author: John Gallagher
//Purpose: Recreate the caeser-cipher from UDEMY course titled "Learn Cryptography Basic".



public class CaesarCipher {

//Class for the key 
class Constants {
	
	private Constants(){

	}
	public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int KEY = 3;
}

//Method to encrypt message
public String encrypt(String plainText) {

//the encrypted message
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

//Method to decrypt message, most annotations similar to encrypt

public String decrypt(String secretText) {
	
String decryptedText = "";

	for (int i = 0; i <secretText.length(); i++){
	
		char character = secretText.charAt(i);

		int charIndex = Constants.ALPHABET.indexOf(character);

		//this part uses a subtraction operator, the encrypt had an addition operator
		int decryptIndex = Math.floorMod(charIndex - Constants.KEY, Constants.ALPHABET.length());

		decryptedText = decryptedText + Constants.ALPHABET.charAt(decryptIndex);
	
	}
return decryptedText;
}

public static void main(String[] args) {
	CaesarCipher cipher = new CaesarCipher();
	String cipherText = cipher.encrypt("hello");
	String decryptedText = cipher.decrypt(cipherText);
	System.out.print(cipherText + "\n \n");
	System.out.print(decryptedText);
}
}

//Notes: Be able to answer why we use floor.mod in JAVA. Why not just use the modulus %.
//It's because the modulus operator can't take into account negative nubmers.