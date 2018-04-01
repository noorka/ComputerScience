//
//  AttackTwo.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef AttackTwo_hpp
#define AttackTwo_hpp

#include <stdio.h>
#include <cstdlib>
#include <string>
#include <stdlib.h>
#include <time.h>
#include "BattleMove.hpp"
#include "Actor.hpp"

using namespace std;

class AttackTwo: public BattleMove {
protected:
    int actualDamage;
    
public:
    AttackTwo() = default;
    void execute();
    void undo();
    ~AttackTwo() = default;
    int getActionAmt(){return actualDamage;}
};
//Will generate a random damage between 0 and 25
//Same logic as attack one

#endif /* AttackTwo_hpp */
