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
    Actor* playerOne;
    Actor* playerTwo;
    MoveManager mgr;
    
public:
    Runner();
    void printPlayer();
    void printOpponent();
    void printChoice();
    int menuChoice(int pick);
    int inputOne(int pers);
    int inputTwo(int pers);
    Actor* getPlayerOne();
    Actor* getPlayerTwo();
    void printAction();
    string getRandom(Actor* player);
    bool isDead(Actor* player);
};


#endif /* Runner_hpp */
