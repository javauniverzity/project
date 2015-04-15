package cz.bodyplan.be.spring.component;

import java.io.IOException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import cz.bodyplan.web.interfaces.component.SecurityComponent;

@Component
public class SecurityComponentImpl implements SecurityComponent {

	private static final Logger logger = Logger.getLogger(SecurityComponentImpl.class);

	private static final Object aesLock = new Object();

	private static Key key = null;

	private static final String SECURE = "HLKJHHKJHK54HJDLKJJD";

	private static Cipher aesCipherDecrypt = null;
	private static Cipher aesCipherEncrypt = null;

	private static void initAES() throws Exception {

		if (aesCipherDecrypt == null) {
			synchronized (aesLock) {
				aesCipherDecrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
				aesCipherDecrypt.init(Cipher.DECRYPT_MODE, getKey());
			}
		}
		if (aesCipherEncrypt == null) {
			synchronized (aesLock) {
				aesCipherEncrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
				aesCipherEncrypt.init(Cipher.ENCRYPT_MODE, getKey());
			}
		}
	}

	@Override
	public String decode(final String text) {
		try {
			initAES();
			final byte[] decode = Base64.decode(text.getBytes());
			byte[] decrypted = null;
			synchronized (aesLock) {
				decrypted = aesCipherDecrypt.doFinal(decode);
			}
			final String decryptedData = new String(decrypted, "UTF-8");
			return decryptedData;
		} catch (final Exception ex) {
			logger.error("Decode exception", ex);
		}

		return null;
	}

	@Override
	public String encode(final String text) {
		try {
			initAES();
			final byte[] sourceData = text.getBytes("UTF-8");
			byte[] encrypted = null;
			synchronized (aesLock) {
				encrypted = aesCipherEncrypt.doFinal(sourceData);
			}
			final byte[] encode = Base64.encode(encrypted);

			final String result = new String(encode, "UTF-8");

			return result;
		} catch (final Exception ex) {
			logger.error("Exception", ex);
		}
		return null;
	}

	private static Key getKey() throws IOException {
		if (key == null) {
			final byte[] b = new byte[16];
			final byte[] s = SECURE.getBytes();
			for (int i = 0; i < 16; i++) {
				b[i] = s[i];
			}
			key = new SecretKeySpec(b, "AES");
		}
		return key;
	}

	public static void main(final String[] args) {
		final SecurityComponentImpl i = new SecurityComponentImpl();
		final String a = i.encode("ahoj");
		System.out.println(a);
		System.out.println(i.decode(a));
	}
}
