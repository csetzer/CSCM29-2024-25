package lab3;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.util.ArrayList;

/**
 *  OutputList
 *  defines a list of Outputs of a transaction
 *
 */

public class OutputList{


    /**
      * list of outputs for a transaction
      */

    private ArrayList<Output> outputList;

    /**
      * add a user amount to the list
      */

    public void addEntry(PublicKey sender,int amount){
	outputList.add(new Output(sender,amount));
    }

    /**
      * constructor constructing the empty user aount list
      */

    public OutputList(){
	outputList =  new ArrayList<Output>();
    }

    /**
      * constructor constructing a list containing one entry
      *   consisting of a user and an amount
      */

    public OutputList(PublicKey sender,int amount){
	outputList = new ArrayList<Output>();
	addEntry(sender,amount);
    }


    /**
      * constructor constructing a list containing two entries
      *   each consisting of a user and an amount
      */

    public OutputList(PublicKey sender1,int amount1,
		     PublicKey sender2,int amount2){
	outputList = new ArrayList<Output>();
	addEntry(sender1,amount1);
	addEntry(sender2,amount2);
    }


    /**
      * obtain the underlying list
      */

    public ArrayList<Output> toList(){
	return(outputList);
    };


    /**
      * compute the sum of entries in the list
      */

    public int toSum(){
	int result = 0;
	for (Output  entry : toList()){
	    result += entry.getAmount();
		};
	return result;
    };


    /**
      *
      * the operation toLedger is defined similarly as for InputList.
      *
      * We don't need it really since it is only used for checking in case of inputs
      *   that they can be deducted
      *
      * We still keep it since it may be of use in the future.
      *
      */

    public Ledger toLedger(){
	Ledger result = new Ledger();
	for (Output  entry : toList()){
	    result.addToBalance(entry.getRecipient(),entry.getAmount());
	};
	return result;

    }


    /**
     * Creates the message to be signed, if the outpupt is the current OutputList
     *    and the sender and amount are the inputs
     *
     *  see the lecture where we discussed that the user signs his input and all outputs
     *
     */

    public byte[] getMessageToSign(PublicKey sender, int amount){
	SigData sigData = new SigData();
	sigData.addPublicKey(sender);
	sigData.addInteger(amount);
        for (Output output : toList()) {
	    sigData.addPublicKey(output.getRecipient());
	    sigData.addInteger(output.getAmount());
        }
	return sigData.toArray();
    }


    /**
     * If we have PublicPrivateKeyMap containing the sender,
     * we can create a signature for the message consisting of the output and
     *   input given by sender and amount
     */


    public byte[] getSignature(PublicKey sender, int amount,PublicPrivateKeyMap keyMap)
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	return keyMap.signMessage(getMessageToSign(sender,amount),keyMap.getUser(sender));
    }


    /* we can check that a signature is correct for input given by
     *   pubkeySender and amount
     *  and the current output list
     */


    public boolean checkSignature(PublicKey pubkeySender, int amount,byte[] signature){
	return Crypto.verifySignature(pubkeySender,getMessageToSign(pubkeySender,amount),
				      signature);
    }




    /**   function  to print all items in the User Mmaount Listo
     *    in the form
     *      word1  <user> word2 <amount>
     %
     *   we use the pubKeyMap in order to look up the names for each public key
     */

    public void print(String word1, String word2,PublicKeyMap pubKeyMap) {
	for (Output entry : outputList) {
	    entry.print(word1,word2,pubKeyMap);
	}
    }

    /**
     * Default way of printing out the useramount
     */

    public void print(PublicKeyMap pubKeyMap) {
	print("User: "," value:  ",pubKeyMap);
    }

    /**
     * Generic Test cases, providing a headline
     *    printing out the user amount list
     *    and printing out the sum of amounts in the user amount list.
     */


    public void testCase(String header,PublicKeyMap pubKeyMap){
	System.out.println(header);
	print(pubKeyMap);
	System.out.println("Sum of Amounts = " + toSum());
	System.out.println();
    };

    /**
     * Test cases
     */

    public static void test()
		throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	PublicPrivateKeyMap keyMap = SampleKeyMap.generate(new String[]{ "Alice", "Bob", "Carol", "David"});
	PublicKeyMap pubKeyMap = keyMap.toPublicKeyMap();
	PublicKey pubKeyA =	pubKeyMap.getPublicKey("Alice");
	PublicKey pubKeyB =	pubKeyMap.getPublicKey("Bob");
	(new OutputList(pubKeyA,10)).testCase("Test Alice 10",pubKeyMap);

	(new OutputList(pubKeyB,20)).testCase("Test Bob 20",pubKeyMap);

	(new OutputList(pubKeyA,10,pubKeyA,10)).testCase("Alice twice 10",pubKeyMap);

	OutputList l = new OutputList(pubKeyA,10,
				    pubKeyB,20);
	l.testCase("Test Alice 10 and Bob  20",pubKeyMap);

	System.out.println("Same List but with words User and spends");
	l.print("User "," spends ",pubKeyMap);

    }


    /**
     * main function running test cases
     */

    public static void main(String[] args)
    		throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	OutputList.test();
    }

};
