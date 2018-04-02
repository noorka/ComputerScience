//
//  Runner.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Runner.hpp"
/* 
 This will be the class to run the battle. First it will prompt the user for a choice of player 1 and player 2. Then it will allow the user to select one of three choices mentioned in the first sectio. After each choice, If it is a move, select a random move from the actor's list of moves and DoMove with it (passing in the movemanager to take care of it). If the choice is an undo, invoke the MoveManager's UndoLastMove() method. Make sure to check for a stackEmpty exception. After a move print the state of each character.
 */

// Constructor
Runner::Runner(){
    mgr = MoveManager();
}

void Runner::printPlayer(){
    string players = "Select a player:\n1) Ghost\n2) Knight\n3) Warrior\n";
    cout << players;
}
void Runner::printOpponent(){
    string players = "Select an opponent:\n1) Ghost\n2) Knight\n3) Warrior\n";
    cout << players;
}
void Runner::printChoice(){
    string menu = "Choose move:\n1) P1 -> P2\n2) P2 -> P1\n3) Undo\n";
    cout << menu;
}
vector <string> moveVec;
string moveType;
int moveTypeIndex;
int Runner::menuChoice (int pick){
    switch(pick){
        case 1:
            //moveType= playerOne.getRandom();
            //player 1 does something to player 2
            playerOne.doMove(&mgr, getRandom(&playerOne), &playerTwo);
            break;
        case 2:
            //player 2 does something to player 1
            playerTwo.doMove(&mgr, getRandom(&playerTwo), &playerOne);
            break;
        case 3:
            // this is the undo option
            mgr.undoLastMove();
            //no moves on stack
            break;
        default:
            cout << "Not a menu option. Try again.";
            return 22;
            break;
    }
    return 0;
}
 
int Runner::inputOne(int pers){
    switch(pers){
        case 1:
            setPlayerOne(Ghost(100, "Ghost"));
            break;
        case 2:
            setPlayerOne(Knight(100, "Knight"));
            break;
        case 3:
            setPlayerOne(Warrior(100, "Warrior"));
            break;
        default:
            cout << "Not a menu option. Try again.\n";
            return 22;
            break;
    }
    //BattleMove.setSelf(playerOne);
    return 0;
}

int Runner::inputTwo(int pers){
    switch(pers){
        case 1:
            setPlayerTwo(Ghost(100, "Ghost"));
            break;
        case 2:
            setPlayerTwo(Knight(100, "Knight"));
            break;
        case 3:
            setPlayerTwo(Warrior(100, "Warrior"));
            break;
        default:
            cout << "Not a menu option. Try again.\n";
            return 22;
            break;
    }
    return 0;
}

void Runner::setPlayerOne (Actor actor){
    playerOne = actor;
}
void Runner::setPlayerTwo (Actor actor){
    playerTwo = actor;
}
void Runner::printAction(){
    printf("[Player: %s, (%i)] [Opponent: %s, (%i)]\n", playerOne.getType().c_str(), playerOne.getHealth(), playerTwo.getType().c_str(), playerTwo.getHealth());
}
string Runner::getRandom(Actor* player){
    vector <string> moveVec = player->getMoves();
    //vector <string> moveVec = {"attackOne"};
    moveTypeIndex = rand() % moveVec.size();
    moveType = moveVec.at(moveTypeIndex);
    return moveType;
}
Actor* Runner::getPlayerOne(){
    return &playerOne;
}
Actor* Runner::getPlayerTwo(){
    return &playerTwo;
}
bool Runner::isDead(Actor* player){
    if (player->getHealth() <= 0){return true;}
    else{
        return false;
    }
}
//fix constructor for actors
//random is hard coded to attackOne in runner-- try with all the things -- also try to fix
//undo???
//try to keep it sucessfully compiling 

