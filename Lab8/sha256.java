import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class sha256{
	public static void main(String a[])
	{
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			Scanner sc = new Scanner(System.in);
			System.out.println("Input");
			String s = sc.nextLine();
			byte[] digest = md.digest(s.getBytes());
			BigInteger no = new BigInteger(1,digest);
			String hashtext = no.toString(16);
			while(hashtext.length()<32){
			hashtext = "0"+hashtext;
			}
			System.out.println(hashtext);
		}
		catch(NoSuchAlgorithmException e)
		{
			System.out.println(e);
		}
		}
	}
