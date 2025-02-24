package lab3;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.util.Hashtable;
import java.util.Set;


/**
 *   Ledger defines a ledger in the ledger model of bitcoins
 */

public class Ledger {

    /**
     * The current ledger, with each account's public Key mapped to its
     *    account balance.
     */

    private Hashtable<PublicKey, Integer> ledgerBase;

    /**
     * Creates a new ledger
     */
    public Ledger() {
	ledgerBase = new Hashtable<PublicKey, Integer>();
    }

    /**
     * Creates a new ledger from a map from string to integers
     */

    public Ledger(Hashtable<PublicKey, Integer> ledgerBase) {
	this.ledgerBase = ledgerBase;
    }

    /**
     * obtain the underlying Treemap from string to integers
     */

    public Hashtable<PublicKey,Integer> getLedgerBase(){
	return ledgerBase;
    };

    /**
      * obtain the list of publicKeys in the tree map
      */

    public Set<PublicKey> getPublicKeys(){
	return getLedgerBase().keySet();
    };




    /**
     * Adds a mapping from new account's name {@code publicKey} to its
     * account balance {@code balance} into the ledger.
     *
     * if there was an entry it is overridden.
     */

    public void addAccount(PublicKey publicKey, int balance) {
	ledgerBase.put(publicKey, balance);
    }

    /**
     * @return true if the {@code publicKey} exists in the ledger.
     */

    public boolean hasPublicKey(PublicKey publicKey) {
	return ledgerBase.containsKey(publicKey);
    }


    /**
     * @return the balance for this account {@code account}
     *
     *  if there was no entry, return zero
     *
     */

    public int getBalance(PublicKey publicKey) {
	if (hasPublicKey(publicKey)){
		return ledgerBase.get(publicKey);
	    } else
	    {  return 0;
	    }
    }


    /**
     * set the balance for {@code publicKey} to {@code amount}
     */


    public void setBalance(PublicKey publicKey, int amount){
	ledgerBase.put(publicKey,amount);
	    };


    /**
     * Imcrements Adds amount to balance for {@code publicKey}
     *
     *  if there was no entry for {@code publicKey} add one with
     *       {@code balance}
     */

    public void addToBalance(PublicKey publicKey, int amount) {
	setBalance(publicKey,getBalance(publicKey) + amount);
    }


    /**
     * Subtracts amount from balance for {@code publicKey}
     */

    public void subtractFromBalance(PublicKey publicKey, int amount) {
	setBalance(publicKey,getBalance(publicKey) - amount);
    }


    /**
     * Check balance has at least amount for {@code publicKey}
     */
    public boolean checkBalance(PublicKey publicKey, int amount) {
	return (getBalance(publicKey) >= amount);
    }


    /*
     * Task 3.2 (i)
     * Fill in the correct solution (similiar to Task 2.1) for
     *   checkLedgerCanBeDeducted
     * which should check whether a ledger can be deducted
     *
     * This is an auxiliary function used to define
     * checkInputListCanBeDeducted
     *
     * It currently returns true as a default value
     */

    public boolean checkLedgerCanBeDeducted(Ledger ledger2){
	return true;
    };


    /**
     * Task 3.2 (ii)
     * Fill in the correct solution (similiar to Task 2.2) for
     * checkInputListCanBeDeducted
     * which should check that a list of publicKey amounts can be deducted
     *     from the current ledger
     *
     * done by first converting the list of publicKey amounts into a ledger
     *     and then checking that the resulting ledger can be deducted.
     *
     * It currently returns true as a default value.
     *
     */


    public boolean checkInputListCanBeDeducted(InputList inputList){
	return true;
    };


    /**
     * Task 3.2 (iii)
     * Fill in the correct solution (similiar to Task 2.3) for
     * subtractInputList
     * which should subtract a list of inputs of a transaction from the ledger
     *
     * It requires that the list to be deducted is deducable.
     * It currently does nothing.
     *
     */




    public void subtractInputList(InputList inputList){
    }



    /**
     * Task 3.2 (iv)
     * Fill in the correct solution (similiar to Task 2.3) for
     *    addOutputList
     * It should add a list of outputs of a transaction to the current ledger
     *
     * It currently does nothing
     */

    public void addOutputList(OutputList outputList){
    }

    /**
     *
     *  Task 3.3 Check a transaction is valid.
     *     This extends Task 2.4 by checking signatures
     *
     *  A transaction is valid if the following holds:
     *    - the sum of outputs is less than the sum of inputs
     *    - all signatures are valid
     *    - the inputs can be deducted from the ledger.

     *    The return value has just been set to true so that the code compiles.
     *
     */

    public boolean checkTransactionValid(Transaction tr){
	return true;
    };


    /**
     * Task 3.2 (v)
     * Fill in the correct solution (similiar to Task 2.5) for
     *    processTransaction
     *
     * It should process a transaction
     *    by first deducing all the inputs
     *    and then adding all the outputs.
     *
     * It currently does nothing
     */

    public void processTransaction(Transaction tr){
    };


    /**
     * print prints the current state of the ledger.
     */

    public void print(PublicKeyMap pubKeyMap) {
	for (PublicKey publicKey : ledgerBase.keySet()) {
	    Integer value = ledgerBase.get(publicKey).intValue();
	    System.out.println("The balance for " + pubKeyMap.getUser(publicKey) + " is " + value);
	}

    }



    /**
     * Testcase
     */

    public static void test()
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

	/**
	 *  The following code has been commented out since it is not used
         *  you can uncomment it and use it for Task 3.4
         *
	 * PublicKeyMap pubKeyMap = keyMap.toPublicKeyMap();
	 * PublicKey pubKeyA =	pubKeyMap.getPublicKey("Alice");
	 * PublicKey pubKeyB =	pubKeyMap.getPublicKey("Bob");
	 * PublicKey pubKeyC =	pubKeyMap.getPublicKey("Carol");
	 * PublicKey pubKeyD =	pubKeyMap.getPublicKey("David");

	 * byte[] sampleMessage1 = KeyUtils.integer2ByteArray(1);
	 * byte[] sampleMessage2 = KeyUtils.integer2ByteArray(2);
	 * byte[] signature1 = keyMap.signMessage(sampleMessage1,"Alice");
	 * byte[] signature2 = keyMap.signMessage(sampleMessage2,"Bob");
         *
	 */

	/**
	 *  Task 3.4
         *     add  the test cases as described in the lab3 instructions.
	 *
	 **/


    }

    /**
     * main function running test cases
     */

    public static void main(String[] args)
	throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
	Ledger.test();
    }
}
