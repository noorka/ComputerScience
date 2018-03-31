//
//  Runner.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Runner_hpp
#define Runner_hpp

#include <stdio.h>
#include <string>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>
#include <time.h>
#include "Actor.hpp"
#include "Ghost.hpp"
#include "Knight.hpp"
#include "Warrior.hpp"
#include "BattleMove.hpp"
#include "MoveManager.hpp"

using namespace std;

class Runner {
private:
    Actor playerOne;
    Actor playerTwo;
    MoveManager mgr;
    
public:
    Runner();
    void printPlayer();
    void printOpponent();
    void printChoice();
    int menuChoice(int pick);
    int inputOne(int pers);
    int inputTwo(int pers);
    void setPlayerOne(Actor actor);
    void setPlayerTwo(Actor actor);
    Actor* getPlayerOne();
    Actor* getPlayerTwo();
    void printAction();
    string getRandom(Actor player);
    void printMove();
    bool isDead(Actor* player);
};

/*
 This will be the class to run the battle. First it will prompt the user for a choice of player 1 and player 2. Then it will allow the user to select one of three choices mentioned in the first sectio. After each choice, If it is a move, select a random move from the actor's list of moves and DoMove with it (passing in the movemanager to take care of it). If the choice is an undo, invoke the MoveManager's UndoLastMove() method. Make sure to check for a stackEmpty exception. After a move print the state of each character.
 */

#endif /* Runner_hpp */
