//
//  MoveManager.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef MoveManager_hpp
#define MoveManager_hpp

#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Stack.hpp"
#include "BattleMove.hpp"
#include "AttackOne.hpp"
#include "AttackTwo.hpp"
#include "Heal.hpp"

using namespace std;


class MoveManager {
private:
    Stack<BattleMove*> stack;
    
public:
    MoveManager();
    enum MoveType{ attackOne, attackTwo, heal };
    void doMove(MoveType moveType, Actor* actionPlayer);
    void undoLastMove();
    ~MoveManager();
};


#endif /* MoveManager_hpp */


