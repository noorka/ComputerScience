//
//  Actor.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Actor_hpp
#define Actor_hpp


#include <stdio.h>
#include <string>
#include <stdlib.h>
#include <vector>
#include <iostream>


using namespace std;

class MoveManager;

class Actor{
protected:
    string type;
    int health;
    vector <string> moveTypes;
public:
    Actor() = default;
    virtual ~Actor() = default;
    vector <string> virtual getMoves(){return {"empty"};};
    
    Actor(int health, string type);
    void doMove(MoveManager* mgr, string ChoiceType, Actor* player);
    void hit(int damage, Actor* myPlayer);
    void heal(int amount, Actor* myPlayer);
    string getType();
    int getHealth();
};


#endif /* Actor_hpp */
