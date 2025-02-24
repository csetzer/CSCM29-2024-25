package lab3;

import java.util.HashMap;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.util.Set;


public class PublicPrivateKeyMap {
    private HashMap<String,PrivateKey> user2PrivateKey;
    private PublicKeyMap  publicKeyMap;


    public PublicPrivateKeyMap(){
	this.user2PrivateKey = new HashMap<String,PrivateKey> ();
	this.publicKeyMap = new PublicKeyMap();
    }


    public PublicPrivateKeyMap(HashMap<String,PrivateKey> user2PrivateKey,
			       HashMap<String,PublicKey> user2PublicKey,
			       HashMap<PublicKey,String> publicKey2User) {
	this.user2PrivateKey = new HashMap<String,PrivateKey> (user2PrivateKey);
	this.publicKeyMap = new PublicKeyMap(user2PublicKey,publicKey2User);
    }

    public void addKey(String user,PrivateKey privateKey, PublicKey publicKey){
	user2PrivateKey.put(user,privateKey);
	publicKeyMap.addKey(user,publicKey);
    }


    public PublicKeyMap toPublicKeyMap(){
	return new PublicKeyMap(publicKeyMap);
    }

    public HashMap<String,PrivateKey> getUser2PrivateKey(){
	return new HashMap<String,PrivateKey>(user2PrivateKey);
    }

    public HashMap<String,PublicKey> getUser2PublicKey(){
	return publicKeyMap.getUser2PublicKey();
    }


    public HashMap<PublicKey,String> publicKey2User(){
	return publicKeyMap.publicKey2User();
    }


    public String getUser(PublicKey pbk) {
	return publicKeyMap.getUser(pbk);
    }


    public PublicKey getPublicKey(String user) {
	return publicKeyMap.getPublicKey(user);
    }

    public String getPublicKeyString(String user)throws NoSuchAlgorithmException {
	return publicKeyMap.getPublicKeyString(user);
    };


    public PrivateKey getPrivateKey(String user) {
	return user2PrivateKey.get(user);
    }

    public Set<String> getUsers(){
	return publicKeyMap.getUsers();
    }

    public byte[] signMessage(byte[] message,String user)
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException{
	return Crypto.sign(getPrivateKey(user),message);
    }




}
