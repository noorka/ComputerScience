//
//  AttackOne.cpp
//  Program 2


#include "AttackOne.hpp"

void AttackOne::execute(){
    actualDamage = rand() % 5 + 10;
    player->hit(actualDamage, player);

}
void AttackOne::undo(){
    player->heal(actualDamage, player);
}
