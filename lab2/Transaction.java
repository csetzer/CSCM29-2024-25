package lab2;

/**   Transaction
 *    consisting of a list of inputs and
 *    a list of outputs
 */

public class Transaction {

    /** The list of inputs  */
    private UserAmountList inputs;

    /** The list of outputs  */
    private UserAmountList outputs;


    /**
     * Creates a new transaction
     */
    public Transaction(UserAmountList inputs, UserAmountList outputs){
	this.inputs = inputs;
	this.outputs= outputs;
    }

    /**
     * return the list of inputs
     */

    public UserAmountList toInputs(){
	return inputs;
    }


    /**
     * return the list of outputs
     */

    public UserAmountList toOutputs(){
	return outputs;
    }


    /**
     * check the sum of inputs is >= the sum of outputs
     */

    public boolean checkTransactionAmountsValid (){
	return (toInputs().toSum() >= toOutputs().toSum());
    }

    /**
     * print the transaction
     */


    public void print() {
	System.out.println("Inputs:");
        toInputs().print("User: "," spends ");
	System.out.println("Outputs:");
        toOutputs().print("User: "," receives ");
    }


    /**
     * Generic Test cases, providing a headline
     *    printing out the transaction
     *    and printing out whether it is valid
     */


    public void testCase(String header){
	System.out.println(header);
	print();
	System.out.println("Is valid regarding sums = " + checkTransactionAmountsValid());
	System.out.println("");
    }


    /**
     * Test cases
     */

    public static void test(){
	Transaction tr;
	tr = new Transaction(new UserAmountList(),
			     new UserAmountList());
	tr.testCase("Transaction null to null");
	tr = new Transaction(new UserAmountList("Alice",10),
			     new UserAmountList("Bob",5));
	tr.testCase("Transaction Alice 10  to Bob 5");


	tr = new Transaction(new UserAmountList("Alice",5),
			     new UserAmountList("Bob",10));
	tr.testCase("Transaction Alice 5  to Bob 10");

	tr = new Transaction(new UserAmountList("Alice",10,"Bob",5),
			     new UserAmountList("Alice",7,"Carol",8));
        tr.testCase("Transaction Alice 10  Bob 5 to Alice 7 Carol 8");

	tr = new Transaction(new UserAmountList("Alice",10,"Bob",5),
			     new UserAmountList("Alice",10,"Carol",8));
        tr.testCase("Transaction Alice 10  Bob 5 to Alice 10 Carol 8");

    }


    /**
     * main function running test cases
     */

    public static void main(String[] args) {
	Transaction.test();
    }

}
