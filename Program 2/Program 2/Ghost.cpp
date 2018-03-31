//
//  Ghost.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Ghost.hpp"
//Will have AttackOne and Heal in vector of MoveTypes, and 100 health
Ghost::Ghost(int health, string type){
    this -> health = health;
    this-> type = type;
}
vector <string> Ghost::getMoves(){
    return moveTypes;
}
