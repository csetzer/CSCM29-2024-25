// SPDX-License-Identifier: LGPL -3.0
pragma solidity >=0.8.24;
import "./Nft.sol";
import "./Client.sol";

contract Testnft {
    // the underlying nft
    Nft public nft;

    // an array of clients, which interect with the nft for testing
    // client numbers are valid iff they are less than the length of this array.
    Client []  public client;

    constructor () payable{
        nft = new Nft();
    }

    // Task 5.6
    // create clients by first initialising client to an array of length _numClients
    // and then initialising each client to a client referring to nft 
    function createClients (uint _numClients) public {
    }

    // Task 5.7
    // define a function which charges a client with a given amount.
    // by transferring the amount of ether to it
    // Use the correct transfer function (based on .call())
    // The transfer will ony work if the contract Testnft has enough ether
    //
    function chargeClient(uint clientNumber,uint amount) public {
    }


    // Task 5.8
    // check the balance of a client.
    // requires that clientNumber is a valid client number
    
    function balanceOfClient(uint clientNumber) public view returns (uint)  {
    }

    // Task 5.9
    // let client number clientNumber create an item with the given price
    // requires that clientNumber is a valid client number

    function createItem(uint clientNumber,string memory _item, uint _price) public {
    }

    // Task 5.10
    // let client number clientNumber buy item using the given amount of money.
    // requires that clientNumber is a valid client number
    // this should fail if the client has not enough ether
    

    function buy (uint clientNumber,string memory _item,uint amount) public payable {
    }

    // Task 5.11
    // let client number clientNumber change the price of the item
    // requires that clientNumber is a valid client number

    function changePrice(uint clientNumber, string memory _item, uint newPrice) public {
    }

    // Task 5.12
    // determine which clientnumber is the owner of item
    // if the owner is not one of the clients in client, it should return (false,0)
    // otherwise (true,i) where i is the client owning that item.

    function getOwner(string memory _item) public view returns (bool success,uint clientNumber){
    }

    // Task 5.13
    // determine the price of item

    function getPrice(string memory _item) public view returns (uint price) {
    }


    // Event displaying  the balance of a client
    
    event  balanceOfClientEv(string message,uint clientNum,uint amount);

    // This will emit an event consisting of a message (i.e. info about the action
    //    which will take place or took place before this call)
    // showing the balance of the client
    //
    // This is not an official task but you need to answer it to solve Task 5.16
    function showBalanceOfClient(string memory message,uint clientNumber) public {
    }
     
     
    event showOwnerEv(string message, string item, bool isOwned,uint clientNum);


    // Task 5.14
    // this function should issue an showOwnerEv containing the mssage the item,
    //   whether it is owned and the client number as determeind by getOwner(_item)
    function showOwner(string memory _message, string memory _item) public {
    }

    event priceOfItemEv(string message,string item,uint price);

    // Task 5.15
    // this function should issue a priceOfItemEv showing the price of the item
    function showPriceOfItem(string memory message, string memory _item) public {
    }
    
    // Task 5.16
    // Successful running of this test case requires that Testnft was
    //   deployed with a sufficient balance so that all tests can be 
    //   carried out
    // runTest should execute the following activities (where show means:
    //       emitting an event with that information
    //    create 3 clients
    //    charge client 1 with 2 ether
    //    show balance fo client 1
    //    let client 0 create an item "test" with price 1 ether
    //    show the owner of "test"
    //    show balance of client 0
    //    let client 1 buy "test" for 1 ether
    //    show owner and price of "test"
    //    show balance of client 0  + 1
    //    change price of "test" to 2 ether
    //    show price of "test"
    //
    //    let client 0 create an item "test2" with price 1 ether
    //    show the owner of "test2"
    //    show balance of client 1  + 2
    //    let client 1 buy test2 for 1 ether
    //    show owner and balance of all clients after buying
    
    function runTest() public {
    }
}
     
	
