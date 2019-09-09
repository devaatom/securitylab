import java.util.Scanner;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.KeyFactory;

import java.security.PublicKey;

import java.security.Signature;

import java.security.spec.X509EncodedKeySpec;

import java.security.InvalidKeyException;

import java.security.MessageDigest;

import java.security.Key;
import java.security.NoSuchAlgorithmException;



import javax.crypto.BadPaddingException;



import javax.crypto.Cipher;



import javax.crypto.IllegalBlockSizeException;



import javax.crypto.NoSuchPaddingException;



import javax.crypto.spec.SecretKeySpec;

public class aes{
	
	public static void main(String a[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		String text = sc.nextLine();
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(key.getBytes());
kgen.init(128, sr);
SecretKey skey = kgen.generateKey();
byte [] raw = skey.getEncoded();
		Key secretKey = new SecretKeySpec(raw, "AES");



			Cipher cipher = Cipher.getInstance("AES");



			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] outputBytes = cipher.doFinal(text.getBytes());
			System.out.println(new String(outputBytes));
			cipher = Cipher.getInstance("AES");



			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			System.out.println(new String(cipher.doFinal(outputBytes)));
	}
}