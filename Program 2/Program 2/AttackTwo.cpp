//
//  AttackTwo.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "AttackTwo.hpp"
//Will generate a random damage between 0 and 25
//Same logic as attack one
void AttackTwo::execute(){
    actualDamage = rand() % 25;
    player->hit(actualDamage, player);
    
}
void AttackTwo::undo(){
    player->heal(actualDamage, player);
}
