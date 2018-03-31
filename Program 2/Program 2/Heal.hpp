//
//  Heal.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Heal_hpp
#define Heal_hpp

#include <stdio.h>
#include <string>
#include <stdlib.h>
#include <time.h>
#include "BattleMove.hpp"
#include "Actor.hpp"

using namespace std;

class Heal: public BattleMove {
protected:
    int actualHeal;
public:
    Heal() = default;
    void execute();
    void undo();
    virtual ~Heal() = default;
};

//Will generate a random heal amount between 10 and 15
//Execute will call Heal on self with the actual heal amount and save it in a member variable.
//Undo will call Hit on self to undo the Heal (with amount stored in the member variable)

#endif /* Heal_hpp */
