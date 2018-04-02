//
//  AttackTwo.hpp
//  Program 2


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
#endif /* AttackTwo_hpp */
