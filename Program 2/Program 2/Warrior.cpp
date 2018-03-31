//
//  Warrior.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Warrior.hpp"
//Will have AttackOne and AttackTwo in vector of MoveTypes, and 100 health
Warrior::Warrior(int health, string type){
    this -> health = health;
    this-> type = type;
}
vector <string> Warrior::getMoves(){
    return moveTypes;
}
