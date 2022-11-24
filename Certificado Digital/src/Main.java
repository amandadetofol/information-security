import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {

	public static void main(String[] args)
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {

		/*
		 * Questão 1 Crie um programa que abra a keystore e exiba as seguintes
		 * propriedades dos certificados importados: a) Quem é o proprietário do
		 * certificado? b) Quem é o emissor do certificado? c) Identifique se o
		 * certificado é auto-assinado ou não. d) Qual o período de validade do
		 * certificado?
		 */
		KeyStoreReader.readCertificatesProperties();

		/*
		 * Questão 2 Cifre a imagem publicada no AVA com o algoritmo AES utilizando a
		 * chave constituída de 16 bytes com caractere “A”. Utilize a chave pública do
		 * certificado importado para cifrar a chave do algoritmo simétrico. Armazene a
		 * chave num arquivo binário chamado “key.aes”.
		 */
		byte[] content = FileManager.readFile("/Users/amandadetofol/Downloads/imagemparacifrar.jpg");
		AesCrypto.crypt(content);
		FileManager.saveInFile("/Users/amandadetofol/Downloads/key.aes", (encrypt("AAAAAAAAAAAAAAAA".getBytes())));
	}

	public static byte[] encrypt(byte[] text)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, KeyStoreException, CertificateException, IOException {
		Cipher c = Cipher.getInstance("RSA");
		c.init(Cipher.ENCRYPT_MODE, KeyStoreReader.getPublickKey());
		byte[] simpleText = text;
		byte[] cipherText = c.doFinal(simpleText);
		return cipherText;
	}

}
