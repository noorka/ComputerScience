//
//  Ghost.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Ghost_hpp
#define Ghost_hpp


#include <stdio.h>
#include <string>
#include <stdlib.h>
#include <vector>
#include "Actor.hpp"


using namespace std;

class Ghost : public Actor{
protected:
    vector <string> moveTypes = {"attackOne", "heal"};
    
public:
    Ghost() = default;
    ~Ghost() = default;
    Ghost(int health, string type);
    vector <string> getMoves(){return moveTypes;}
};

//Will have AttackOne and Heal in vector of MoveTypes, and 100 health

#endif /* Ghost_hpp */
