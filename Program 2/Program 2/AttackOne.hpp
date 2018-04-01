//
//  AttackOne.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef AttackOne_hpp
#define AttackOne_hpp

#include <stdio.h>
#include <cstdlib>
#include <string>
#include <stdlib.h>
#include <time.h>
#include "BattleMove.hpp"
#include "Actor.hpp"

using namespace std;

class AttackOne: public BattleMove{
protected:
    int actualDamage;
    
public:
    AttackOne() = default;
    void execute();
    void undo();
    ~AttackOne() = default;
    int getActionAmt(){return actualDamage;}
    
};


//Will generate a random damage between 10 and 15
//Execute will call the Hit method of other and save the actualDamage done in a local variable.
//Undo will call the Heal method of other with the saved actualDamage variable (to undo the damage)

#endif /* AttackOne_hpp */
