
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class DocumentSigner {
	
	byte[] simpleText = null;

	public byte[] signDocument(String fullDocPath, PrivateKey object)
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException {
		byte[] textoSimples = FileManager.readFile(fullDocPath);
		simpleText = textoSimples;
		
		Signature signature = Signature.getInstance("SHA1WithRSA");
		signature.initSign(object);
		signature.update(simpleText);
		byte[] bsignature = signature.sign();
		FileManager.saveInFile(fullDocPath + "SIGNATURE", bsignature);
		return bsignature;
	}

	public boolean isValidSignature(byte[] siganature, PublicKey publicKey, String fullDocPath) throws NoSuchAlgorithmException, IOException, SignatureException, InvalidKeyException {
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initVerify(publicKey);
		signature.update(simpleText);
		if (signature.verify(siganature)) {
			return true;
		} else {
			return false;
		}
	}

}
