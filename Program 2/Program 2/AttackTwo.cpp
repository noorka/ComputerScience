//
//  AttackTwo.cpp
//  Program 2


#include "AttackTwo.hpp"
void AttackTwo::execute(){
    actualDamage = rand() % 25;
    player->hit(actualDamage, player);
    
}
void AttackTwo::undo(){
    player->heal(actualDamage, player);
}
