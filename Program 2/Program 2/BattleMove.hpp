//
//  BattleMove.hpp
//  Program 2


#ifndef BattleMove_hpp
#define BattleMove_hpp

#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Actor.hpp"

using namespace std;

class BattleMove {
    
protected:
    Actor* player;

public:
    void virtual execute()=0;
    void virtual undo()=0;
    virtual ~BattleMove() = default;
    void setPlayer(Actor* pawn);
    int virtual getActionAmt()=0;
};

#endif /* BattleMove_hpp */
