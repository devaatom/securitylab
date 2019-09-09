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
import java.io.*;

import java.net.*;

import java.util.Scanner;

public class tcpserver{

    public static void main(String[] args)throws Exception{

        ServerSocket ss = new ServerSocket(8000);

        Socket s = ss.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());

        String i = din.readUTF();
Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(key.getBytes());
kgen.init(128, sr);
SecretKey skey = kgen.generateKey();
byte [] raw = skey.getEncoded();
		Key secretKey = new SecretKeySpec(raw, "AES");



			Cipher cipher = Cipher.getInstance("AES");



			cipher.init(Cipher.DECRYPT_MODE, secretKey);
System.out.println(new String(cipher.doFinal(i.getBytes())));


        ss.close();

    }

}