//
//  Knight.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Knight.hpp"
//Will have AttackTwo and Heal in vector of MoveTypes, and 100 health
Knight::Knight(int health, string type){
    this->health = health;
    this->type = type;
}
