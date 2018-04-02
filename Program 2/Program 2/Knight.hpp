//
//  Knight.hpp
//  Program 2


#ifndef Knight_hpp
#define Knight_hpp


#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Actor.hpp"

using namespace std;

class Knight: public Actor {
protected:
    vector <string> moveTypes= {"attackTwo", "heal"};
public:
    Knight() = default;
    ~Knight() = default;
    Knight(int health, string type);
    vector <string> getMoves(){return moveTypes;}
};


#endif /* Knight_hpp */
