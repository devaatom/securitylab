import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import java.security.Key;

import java.security.InvalidKeyException;



import java.security.NoSuchAlgorithmException;



import javax.crypto.BadPaddingException;




import javax.crypto.IllegalBlockSizeException;



import javax.crypto.NoSuchPaddingException;
public class des{
public static void main(String a[]){
	try {
Scanner sc = new Scanner(System.in);
String key = sc.nextLine();
String text = sc.nextLine();

KeyGenerator kgen = KeyGenerator.getInstance("DES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(key.getBytes());
kgen.init(56, sr);
SecretKey skey = kgen.generateKey();
byte [] raw = skey.getEncoded();
SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] outputBytes = cipher.doFinal(text.getBytes());
System.out.println(new String(outputBytes));
cipher = Cipher.getInstance("DES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
System.out.println(new String(cipher.doFinal(outputBytes)));
	}
	catch (NoSuchPaddingException | NoSuchAlgorithmException 

				| InvalidKeyException | BadPaddingException

				| IllegalBlockSizeException e) {

			e.printStackTrace();

		}
}
}