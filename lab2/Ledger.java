package lab2;

import java.util.TreeMap;
import java.util.Set;


/**
 *   Ledger defines a ledger in the ledger model of bitcoins
 */

public class Ledger {

    /**
     * The current ledger, with each account's name mapped to its
     *    account balance.
     */

    private TreeMap<String, Integer> ledgerBase;

    /**
     * Creates a new ledger
     */
    public Ledger() {
	ledgerBase = new TreeMap<String, Integer>();
    }

    /**
     * Creates a new ledger from a map from string to integers
     */

    public Ledger(TreeMap<String, Integer> ledgerBase) {
	this.ledgerBase = ledgerBase;
    }

    /** obtain the underlying Treemap from string to integers
     */

    public TreeMap<String,Integer> getLedgerBase(){
	return ledgerBase;
    };

    /**
      * obtain the list of users in the tree map
      */

    public Set<String> getUsers(){
	return getLedgerBase().keySet();
    };




    /**
     * Adds a mapping from new account's name {@code user} to its
     * account balance {@code balance} into the ledger.
     *
     * if there was an entry it is overridden.
     */
    public void addAccount(String user, int balance) {
	ledgerBase.put(user, balance);
    }

    /**
     * @return true if the {@code user} exists in the ledger.
     */

    public boolean hasUser(String user) {
	return ledgerBase.containsKey(user);
    }


    /**
     * @return the balance for this account {@code account}
     *
     *  if there was no entry, return zero
     *
     */

    public int getBalance(String user) {
	if (hasUser(user)){
		return ledgerBase.get(user);
	    } else
	    {  return 0;
	    }
    }


    /**
     * set the balance for {@code user} to {@code amount}
     */


    public void setBalance(String user, int amount){
	ledgerBase.put(user,amount);
	    };


    /**
     * Imcrements Adds amount to balance for {@code user}
     *
     *  if there was no entry for {@code user} add one with
     *       {@code balance}
     */

    public void addToBalance(String user, int amount) {
	setBalance(user,getBalance(user) + amount);
    }


    /**
     * Subtracts amount from balance for {@code user}
     */

    public void subtractFromBalance(String user, int amount) {
	setBalance(user,getBalance(user) - amount);
    }


    /**
     * Check balance has at least amount for {@code user}
     */
    public boolean checkBalance(String user, int amount) {
	return (getBalance(user) >= amount);
    }

    /**
     *
     *  Task 1: Fill in the method checkLedgerCanBeDeducted()
     *          It has been commented out so that the code compiles.
     *
     * Check all items in a ledger can be deducted from the current one
     *
     *   the ledger to be deducted is usually obtained
     *   from a list of inputs of a transaction
     */

    /**
    public boolean checkLedgerCanBeDeducted(Ledger ledger2){

    };

    */

    /**
     *
     *  Task 2: Fill in the method checkUALCanBeDeducted
     *          It has been commented out so that the code compiles.
     *
     *  It checks that a list of user amounts can be deducted from the
     *     current ledger
     *
     *   done by first converting the list of user amounts into a ledger
     *     and then checking that the resulting ledger can be deducted.
     *
     */


    /**
    public boolean checkUALCanBeDeducted(UserAmountList ual){

    };

    */

    /**
     *  Task 3: Fill in the methods subtractUAL and  addUAL.
     *
     *   Subtract a list of user amounts (UAL) from the ledger
     *
     *   requires that the list to be deducted is deductable.
     *
     */


    public void subtractUAL(UserAmountList ual){
    }



    /**
     * Add a list of user amounts (UAL) to the current ledger
     *
     */

    public void addUAL(UserAmountList ual){
    }


    /**
     *
     *  Task 4: Fill in the method checkTransactionValid
     *          It has been commented out so that the code compiles.
     *
     * Check a transaction is valid:
     *    the sum of outputs is less than the sum of inputs
     *    and the inputs can be deducted from the ledger.
     *
     */

    /**
    public boolean checkTransactionValid(Transaction tr){
    };
    */

    /**
     *
     *  Task 5: Fill in the method processTransaction
     *
     * Process a transaction
     *    by first deducting all the inputs
     *    and then adding all the outputs.
     *
     */


    public void processTransaction(Transaction tr){
    };


    /**
     * Prints the current state of the ledger.
     */

    public void print() {
	for (String user : ledgerBase.keySet()) {
	    Integer value = ledgerBase.get(user).intValue();
	    System.out.println("The balance for " + user + " is " + value);
	}

    }


    /**
     *  Task 6: Fill in the testcases as described in the labsheet
     *
     * Testcase
     */

    public static void test() {

    }

    /**
     * main function running test cases
     */

    public static void main(String[] args) {
	Ledger.test();
    }
}
