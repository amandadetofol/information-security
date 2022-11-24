

public class Main {

	public static void main (String[] args) throws Exception {
		System.out.println("QUESTÃO 01");
		KeyGenerator keyGen = new KeyGenerator();
		keyGen.logKeyInformations();
		System.out.println("");
		
		System.out.println("QUESTÃO 02");
		String simpleKey = "amanda"; 
		
		RSAEncryptor rasEnc = new RSAEncryptor();
		byte[] encryptedKey = rasEnc.encrypt(simpleKey.getBytes());
		System.out.println("Texto simples RSA: " + simpleKey);
		System.out.println("Texto cifrado RSA: " + encryptedKey);
		AESEncryptor aesEnc = new AESEncryptor();
		
		byte[] encryptedContent = aesEnc.encrypt(encryptedKey, "Amanda");
		System.out.print("AES Result: " + encryptedContent);
		System.out.println("");
		
		System.out.println("QUESTÃO 03"); 
		byte[] keyDecrypt = rasEnc.decrypt(encryptedKey); 
		String decryptedContent = aesEnc.decrypt(keyDecrypt, encryptedContent);
		System.out.print(decryptedContent);
	}
	
}

