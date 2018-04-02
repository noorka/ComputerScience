//
//  AttackOne.hpp
//  Program 2


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

#endif /* AttackOne_hpp */
