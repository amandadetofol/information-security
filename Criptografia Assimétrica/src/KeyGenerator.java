import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class KeyGenerator {
	
	BigInteger module = null;
	BigInteger publicExp = null ;
	BigInteger privateExp = null;
	PublicKey publickKey = null; 
	PrivateKey privateKey = null;
	
	KeyGenerator() throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(1024);
		
		KeyPair kp = kpg.genKeyPair();
		publickKey = kp.getPublic();
		privateKey = kp.getPrivate();
		
		KeyFactory fact = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec pks = fact.getKeySpec(publickKey, RSAPublicKeySpec.class);
		module =  pks.getModulus();
		publicExp = pks.getPublicExponent();
		
		RSAPrivateKeySpec prks = fact.getKeySpec(privateKey, RSAPrivateKeySpec.class);
		privateExp = prks.getPrivateExponent();		
	}
	
	public void logKeyInformations() throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("Módulo das chaves: " + module);
		System.out.println("Expoente chave pública: " + publicExp);
		System.out.println("Expoente (d) chave privada: " + privateExp);
	}
	
}
