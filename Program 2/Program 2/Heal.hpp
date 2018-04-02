//
//  Heal.hpp
//  Program 2


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
    ~Heal() = default;
    int getActionAmt(){return actualHeal;}
};


#endif /* Heal_hpp */
