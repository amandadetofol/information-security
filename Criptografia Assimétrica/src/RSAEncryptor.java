import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAEncryptor {

	PrivateKey privateKey = null;

	public byte[] encrypt(byte[] text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator keyGen = new KeyGenerator();
		PublicKey key = keyGen.publickKey;
		privateKey = keyGen.privateKey;
		
		Cipher c = Cipher.getInstance("RSA");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] simpleText = text;
		byte[] cipherText = c.doFinal(simpleText);
		return cipherText;
	}
	
	public byte[] decrypt(byte[] toDecode) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bytes = cipher.doFinal(toDecode);
		return bytes;
	}
	
}
