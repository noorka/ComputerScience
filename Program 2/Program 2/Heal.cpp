//
//  Heal.cpp
//  Program 2


#include "Heal.hpp"
void Heal::execute(){
    actualHeal = rand() % 5 + 10;
    player->heal(actualHeal, player);
    
}
void Heal::undo(){
    player->hit(actualHeal, player);
}
