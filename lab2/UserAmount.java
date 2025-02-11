package lab2;

    /** UserAmount
     *  specifies a user and the amount to be transferred
     *  will be used in a transaction as one arrow going in or out
     *    of one transaction
     */


public class UserAmount{

    /** The amount to be transfered  */
    private int amount;

    /** The user */
    private String user;

    /**
     * Create new User Amount
     */

    public UserAmount(String user,int amount){
	this.amount  = amount;
	this.user = user;
    }


    /**
     * Get the user
     */

    public String getUser(){
	return user;
    };

    /**
     * Get the  amount
     */

    public int getAmount(){
	return amount;
    }


    /**
     * Print the entry in the form word1  <user> word2 <amount>
     */

    public void print(String word1, String word2) {
	System.out.println(word1 + getUser() + word2 + getAmount());
    }

    /**
     * Default way of printing out the useramount
     */

    public void print() {
	print("User: "," value:  ");
    }

    /**
     * Test cases
     */

    public static void test() {
	System.out.println();
	System.out.println("Test Alice 10");
	(new UserAmount("Alice",10)).print();
	System.out.println();
	System.out.println("Test Bob 20");
	(new UserAmount("Bob",20)).print();
    };


    /**
     * main function running test cases
     */

    public static void main(String[] args) {
	UserAmount.test();
    }


}
