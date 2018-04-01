//
//  Warrior.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Warrior_hpp
#define Warrior_hpp



#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Actor.hpp"

using namespace std;

class Warrior: public Actor {
protected:
    vector <string> moveTypes= {"attackOne", "attackTwo"};//maybe battle moves
public:
    Warrior() = default;
    ~Warrior() = default;
    Warrior(int health, string type);
    vector <string> getMoves(){return moveTypes;}
};

//Will have AttackOne and AttackTwo in vector of MoveTypes, and 100 health

#endif /* Warrior_hpp */
