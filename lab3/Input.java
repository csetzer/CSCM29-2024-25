package lab3;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.util.Arrays;


/** Input
     *  specifies one input to a transction
     %  given by a public key, and the amount to be transferred
     *    and a signature
     */


public class Input{

    /** The amount to be transfered  */
    private int amount;

    /** The user */
    private PublicKey sender;

    /** The signature produced to check validity */
    private byte[] signature;


    /**
     * Create input from sender, amount, signature
     */

    public Input(PublicKey sender,int amount,byte[] signature){
	this.amount  = amount;
	this.sender = sender;
	this.signature = Arrays.copyOf(signature,signature.length);
    }


    /**
     * If we have a PublicPrivateKeyMap covering the sender
     * and an outputList
     *
     * then we can compute the signature by signing the transaction to be signed consisting
     *    of the public key and input amount and the output list
     *  using the private key of the user
     */

    public Input(String sender,int amount, OutputList outputList,PublicPrivateKeyMap keyMap)
    	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	this.amount = amount;
	this.sender = keyMap.getPublicKey(sender);
	byte[] signatureTmp = outputList.getSignature(this.sender,amount,keyMap);
	this.signature = Arrays.copyOf(signatureTmp,signatureTmp.length);
    };



    /*  as before but referring to the sender by the public key rather than the string */

    public Input(PublicKey sender,int amount, OutputList outputList,PublicPrivateKeyMap keyMap)
    	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	this.amount = amount;
	this.sender = sender;
	byte[] signatureTmp = outputList.getSignature(this.sender,amount,keyMap);
	this.signature = Arrays.copyOf(signatureTmp,signatureTmp.length);
    };



    /**
     * Get the sender
     */

    public PublicKey getSender(){
	return sender;
    };


    /**
     *  get the name of the sender
     *  by looking it up in  a PublicKeyMap
     */

    public String getSenderName(PublicKeyMap keys){
	return keys.getUser(sender);
    };

    /**
     * Get the  amount
     */

    public int getAmount(){
	return amount;
    }

    /**
     * Get the  signature
     */

    public byte[] getSignature() {
	return signature;
    }



    /**
     * Print the entry in the form word1  <sender> word2 <amount>
     *
     *  we use pubKeyMap in order to lookup the user name for each public key
     */

    public void print(String word1, String word2,PublicKeyMap pubKeyMap) {
	System.out.println(word1 + getSenderName(pubKeyMap) + word2 + getAmount());
    }




    /**
     * Default way of printing out the useramount
     */

    public void print(PublicKeyMap keyMap) {
	print("Sender: "," value:  ",keyMap);
    }

    /**
     * Test cases
     */

    public static void test()
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	PublicPrivateKeyMap keyMap = SampleKeyMap.generate(new String[]{ "Alice", "Bob", "Carol", "David"});
	PublicKeyMap pubKeyMap = keyMap.toPublicKeyMap();
	byte[] sampleMessage1 = KeyUtils.integer2ByteArray(1);
	byte[] signedMessage1 = keyMap.signMessage(sampleMessage1,"Alice");
	System.out.println();
	PublicKey pubKeyA =	pubKeyMap.getPublicKey("Alice");
	PublicKey pubKeyB =	pubKeyMap.getPublicKey("Bob");
	System.out.println("Test Alice 10");
	(new Input(pubKeyA,10,signedMessage1)).print(pubKeyMap);
	System.out.println();
	System.out.println("Test Bob 20");
	(new Input(pubKeyB,20,signedMessage1)).print(pubKeyMap);
    };


    /**
     * main function running test cases
     */

    public static void main(String[] args)
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	Input.test();
    }


}
