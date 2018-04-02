//
//  MoveManager.hpp
//  Program 2


#ifndef MoveManager_hpp
#define MoveManager_hpp

#include <stdio.h>
#include <string>
#include <stdlib.h>
#include <iostream>
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
    void printMove(BattleMove* move, Actor* actionPlayer, MoveType moveType);
};


#endif /* MoveManager_hpp */


