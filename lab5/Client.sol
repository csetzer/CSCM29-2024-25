// SPDX-License-Identifier: LGPL -3.0
pragma solidity >=0.8.24;
import "./Nft.sol";


// This defines a virtual client
// i.e. a contract which can create, buy and change the price of NFTs
// it needs to be created by referring to an NFT which has been created before

contract Client {
    Nft nft;

    constructor (Nft _nft) payable {
        nft = _nft;
    }

    function createItem(string memory _item, uint _price) public {
        nft.createItem(_item,_price);
    }

    function buy (string memory _item,uint amount) public {
        nft.buy{value:amount}(_item);
    }

    function changePrice (string memory _item, uint newPrice ) public {
        nft.changePrice(_item,newPrice);
    }
    

    receive () external payable {
    }

}
