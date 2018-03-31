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


using namespace std;

class MoveManager;

class Actor{
protected:
    string type;
    int health;
    //vector <ChoiceType>;
public:
    Actor() = default;
    //virtual ~Actor() = default;
    Actor(int health, string type); //construct actor
    void doMove(MoveManager* mgr, string ChoiceType, Actor* player);
    void hit(int damage, Actor* myPlayer);	//public method to hit THIS actor with damage
    void heal(int amount, Actor* myPlayer);	//public method to heal this actor with an amount
    //vector <string> virtual getMoves();	//vector of MoveTypes
    vector <string> getMoves();	//vector of MoveTypes
    string getType();
    int getHealth();
    

};


#endif /* Actor_hpp */
