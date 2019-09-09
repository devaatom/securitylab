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
import  java.io.*;

import java.util.*;

import  java.net.*;



public class tcpclient{

    

    public static void main(String[] args)throws Exception{

        InetAddress ip = InetAddress.getLocalHost();

        Socket client = new Socket(ip.getHostName(),8000);

        Scanner sc = new Scanner(System.in);

        DataOutputStream dout = new DataOutputStream(client.getOutputStream());
String key = "mykey";
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(key.getBytes());
kgen.init(128, sr);
SecretKey skey = kgen.generateKey();
byte [] raw = skey.getEncoded();
		Key secretKey = new SecretKeySpec(raw, "AES");



			Cipher cipher = Cipher.getInstance("AES");



			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        dout.writeUTF(new String(cipher.doFinal(sc.nextLine().getBytes())));

        

        client.close();

    }

}