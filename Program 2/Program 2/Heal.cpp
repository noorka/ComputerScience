//
//  Heal.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Heal.hpp"
//Will generate a random heal amount between 10 and 15
//Execute will call Heal on self with the actual heal amount and save it in a member variable.
//Undo will call Hit on self to undo the Heal (with amount stored in the member variable)
void Heal::execute(){
    actualHeal = rand() % 5 + 10;
    player->heal(actualHeal, player);
    
}
void Heal::undo(){
    player->hit(actualHeal, player);
}
