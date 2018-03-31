//
//  Knight.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef Knight_hpp
#define Knight_hpp


#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Actor.hpp"

using namespace std;

class Knight: public Actor {
protected:
    string type = "knight";
    vector <string> moveTypes= {"attackTwo", "heal"};//maybe battle moves
public:
    Knight() = default;
    Knight(int health, string type);
    vector <string> getMoves();
};

//Will have AttackTwo and Heal in vector of MoveTypes, and 100 health

#endif /* Knight_hpp */
