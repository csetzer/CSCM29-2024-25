package lab2;

import java.util.ArrayList;

/** UserAmountList
 *  defines a list of UserAmounts
 *  can be used as the list of inputs or list of outputs of a
 *  transaction
 */

public class UserAmountList{


    /**
      * thunderlying list of user amounts
      */

    private ArrayList<UserAmount> userAmountList;

    /**
      * add a user amount to the list
      */

    public void addEntry(String user, int amount){
	userAmountList.add(new UserAmount(user,amount));
    }

    /**
      * constructor constructing the empty user aount list
      */

    public UserAmountList(){
	userAmountList =  new ArrayList<UserAmount>();
    }

    /**
      * constructor constructing a list containing one entry
          consisting of a user and an amount
      */

    public UserAmountList(String user,int amount){
	userAmountList = new ArrayList<UserAmount>();
	addEntry(user,amount);
    }


    /**
      * constructor constructing a list containing two entries
          each consisting of a user and an amount
      */

    public UserAmountList
	(String user1,int amount1,String user2,int amount2)
    {
	userAmountList = new ArrayList<UserAmount>();
	addEntry(user1,amount1);
	addEntry(user2,amount2);
    }


    /**
      * obtain the underlying list
      */

    public ArrayList<UserAmount> toList(){
	return(userAmountList);
    };


    /**
      * compute the sum of entries in the list
      */

    public int toSum(){
	int result = 0;
	for (UserAmount  entry : toList()){
	    result += entry.getAmount();
		};
	return result;
    };


    /**
      * when checking that list of user amount list can be deducted
      *   from a ledger
      *   it is not enough to check that each single item can be deducted
      *   since for the same user several items might occur
      *
      *   in order to check that the user amount list can be deducted
      *    we first create a ledger containing telling for each user the
      *    sum of amounts to be deducted
      *
      *   then we can check whether each entry in the original ledger is
      *     greater the sum of items for each user to be deducted
      */

    public Ledger toLedger(){
	Ledger result = new Ledger();
	for (UserAmount  entry : toList()){
	    result.addToBalance(entry.getUser(),entry.getAmount());
	};
	return result;

    }


    /**   function  to print all items in the User Mmaount List
     *    in the form
     *      word1  <user> word2 <amount>
     */

    public void print(String word1, String word2) {
	for (UserAmount entry : userAmountList) {
	    entry.print(word1,word2);
	}
    }

    /**
     * Default way of printing out the useramount
     */

    public void print() {
	print("User: "," value:  ");
    }

    /**
     * Generic Test cases, providing a headline
     *    printing out the user amount list
     *    and printing out the sum of amounts in the user amount list.
     */


    public void testCase(String header){
	System.out.println(header);
	print();
	System.out.println("transformed to ledger:");
	toLedger().print();
	System.out.println("Sum of Amounts = " + toSum());
	System.out.println();
    };

    /**
     * Test cases
     */

    public static void test() {
	UserAmountList l;
	(new UserAmountList("Alice",10)).testCase("Test Alice 10");

	(new UserAmountList("Bob",20)).testCase("Test Bob 20");

	(new UserAmountList("Alice",10,"Alice",10)).testCase("Alice twice 10");

	l = new UserAmountList("Alice",10,"Bob",20);
	l.testCase("Test Alice 10 and Bob  20");

	System.out.println("Same List but with words User and spends");
	l.print("User "," spends ");

    }


    /**
     * main function running test cases
     */

    public static void main(String[] args) {
	UserAmountList.test();
    }

};
