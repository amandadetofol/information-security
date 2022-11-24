import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;



public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException,
			FileNotFoundException, IOException, ClassNotFoundException, InvalidKeyException, SignatureException {
		
		//Questão 1: Crie dois pares de chaves (par de chaves A e par de chaves B) e armazene-os em disco.
		KeyGenerator kg = new KeyGenerator();
		DiskManager dm = new DiskManager();
		dm.save("APair _AKey", kg.privateKey);
		dm.save("APair _BKey", kg.publickKey);
		PrivateKey APair_PrivateKey = (PrivateKey) dm.getContent("APair _AKey");
		PublicKey APair_PublicKey = (PublicKey) dm.getContent("APair _BKey");
		
		KeyGenerator kg2 = new KeyGenerator();
		dm.save("BPair _AKey", kg2.privateKey);
		dm.save("BPair _BKey", kg2.publickKey);
		PrivateKey BPair_PrivateKey = (PrivateKey) dm.getContent("BPair _AKey");
		PublicKey BPair_PublicKey = (PublicKey) dm.getContent("BPair _BKey");
	
		
		//Questão 2: Crie um programa que possibilite que o usuário forneça um documento para assinar. Utilize a chave de A para assinar a
		//mensagem e armazene a assinatura em um arquivo binário.
		DocumentSigner dc = new DocumentSigner();
		dc.signDocument("/Users/amandadetofol/Documents/teste.rtf", APair_PrivateKey);
		byte[] sigByteFromFile = FileManager.readFile("/Users/amandadetofol/Documents/teste.rtfSIGNATURE");
		System.out.println("Assinatura" + sigByteFromFile);
		
		//Questão 3
		//Crie um programa que valide a origem do arquivo. 
		boolean isValidWithAKey = dc.isValidSignature(sigByteFromFile, APair_PublicKey, "/Users/amandadetofol/Documents/teste.rtf");
		System.out.println("Assinatura é válida: " + isValidWithAKey);
		
		
		//Questão 4: Experimente utilizar a chave B para validar a autoria do arquivo. O que acontece?
		boolean isValidWithBKey = dc.isValidSignature(sigByteFromFile, BPair_PublicKey, "/Users/amandadetofol/Documents/teste.rtf");
		System.out.println("Assinatura é válida: " + isValidWithBKey);
		
	}

}
