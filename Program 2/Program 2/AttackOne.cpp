//
//  AttackOne.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "AttackOne.hpp"
//Will generate a random damage between 10 and 15
//Execute will call the Hit method of other and save the actualDamage done in a local variable.
//Undo will call the Heal method of other with the saved actualDamage variable (to undo the damage)

void AttackOne::execute(){
    //srand(time(NULL));
    actualDamage = rand() % 5 + 10;
    player->hit(actualDamage, player);

}
void AttackOne::undo(){
    player->heal(actualDamage, player);
}
