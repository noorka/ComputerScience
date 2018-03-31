//
//  BattleMove.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

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

    
};

#endif /* BattleMove_hpp */
