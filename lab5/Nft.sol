// SPDX-License-Identifier: LGPL -3.0
pragma solidity >=0.8.24;
contract Nft {

    // The ownership data for an NFT are given by
    // its price, and the owner
    // Owner = 0 means that the NFT hasn't been created yet.

    struct nftData{
        uint price;
        address owner;
    }

    // nftOnwerShip determines who owns which nft and what is the price
    // where nfts are given by a string
    mapping (string item => nftData) public nftOwnership;

    // Task 5.1
    // determine the owner of an nft item by checking nftOwnership
    function getOwner (string memory _item) public view returns (address owner){
    }

    // Task 5.2
    // determine the price of an nft item by checking nftOwnership
    function getPrice(string memory _item) public view returns (uint price){
    }

    // Task 5.3
    // create a new nft
    // Requires that the owner in nftOwnership of _item is address 0 
    //    which means it is not owned yet
    // Then set the owner of the _item to the sender of the message
    //   and the price to the price set.
    function createItem ( string memory _item , uint _price ) public {
        }


    // Task 5.4
    // buy an item
    // requires that the item is owned (address not equal to 0)
    // and the amount of money paid in the transaction is >= the price of the item
    // if this is the case
    //    set the price of the item to price paid
    //    set the owner of the item to be the sender of the msg
    //    transfer the money to the previous owner
    //       (don't use transfer() or send() which is no longer recommended for transfer
    //        use instead the call function)
    function buy (string memory _item) public payable {
        }

    // Task 5.5.
    // Change the price of an item
    // requires that the sender is the owner of the item.
    function changePrice (string memory _item, uint newPrice ) public {
        }

}
