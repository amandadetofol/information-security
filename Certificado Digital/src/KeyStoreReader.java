import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;

public class KeyStoreReader {

	public static void readCertificatesProperties()
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		String password = "12345";
		FileInputStream inputStream = new FileInputStream("/Users/amandadetofol/Desktop/KeyStore01");
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(inputStream, password.toCharArray());

		Certificate certificate01 = (Certificate) keystore.getCertificate("certificado01");
		X509Certificate x509Cert01 = (X509Certificate) certificate01;
		printInformations(x509Cert01);

		Certificate certificate02 = (Certificate) keystore.getCertificate("certificado02");
		X509Certificate x509Cert02 = (X509Certificate) certificate02;
		printInformations(x509Cert02);

		Certificate certificate03 = (Certificate) keystore.getCertificate("certificado03");
		X509Certificate x509Cert03 = (X509Certificate) certificate03;
		printInformations(x509Cert03);

	}

	public static PublicKey getPublickKey()
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		String password = "12345";
		FileInputStream inputStream = new FileInputStream("/Users/amandadetofol/Desktop/KeyStore01");
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(inputStream, password.toCharArray());
		Certificate certificate01 = (Certificate) keystore.getCertificate("certificado01");
		X509Certificate x509Cert01 = (X509Certificate) certificate01;
		return x509Cert01.getPublicKey();
	}

	private static void printInformations(X509Certificate certificate)
			throws CertificateExpiredException, CertificateNotYetValidException {
		System.out.println("");
		System.out.println("--------------------------------------------");
		System.out.println("Proprietário: " + certificate.getSubjectDN());
		System.out.println("Emissor: " + certificate.getIssuerDN());
		System.out.println("É auto-assinado: " + isSelfSigned(certificate));
		System.out.println("Válido de " + certificate.getNotBefore() + " até " + certificate.getNotAfter());
		System.out.println("--------------------------------------------");
	}

	private static boolean isSelfSigned(X509Certificate certificate) {
		if (certificate.getSubjectDN().equals(certificate.getIssuerDN())) {
			return true;
		} else {
			return false;
		}
	}

}
