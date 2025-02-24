package lab3;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Set;
import lab3.LabUtils.CryptoUtils;

public class SampleKeyMap {

    /**
     * generates a publicPrivateKeyMap  for a given list of names
     */

   public static PublicPrivateKeyMap generate(String[] names) throws NoSuchAlgorithmException {
	PublicPrivateKeyMap keymap = new  PublicPrivateKeyMap();
        byte[] initialKey = new byte[32];
	for (int i = 0; i < initialKey.length; i++){
            initialKey[i] = (byte)i;
        }
        SecureRandom prg = new SecureRandom(initialKey);
        int numSizeBits = 2048;
	for (String user : names){
            byte[] key = new byte[32];
            prg.nextBytes(key);
            System.out.println("Generating key pair for user " + user);
            KeyPair rp = CryptoUtils.generateKeyPair(numSizeBits);
	    keymap.addKey(user,rp.getPrivate(),rp.getPublic());
        }
	return keymap;
    }



    public static void test() throws NoSuchAlgorithmException {
	String[] names = new String[]{ "Alice", "Bob", "Carol", "David"};
	PublicPrivateKeyMap keys = generate(names);
	Set<String> users = keys.getUsers();
	for (String user  : users){
	    System.out.println("User = " + user + " public key = " + keys.getPublicKeyString(user));
	}
    }


    public static void main(String[] args) throws NoSuchAlgorithmException{
	test();
    }



}
