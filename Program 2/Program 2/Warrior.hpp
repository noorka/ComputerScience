//
//  Warrior.hpp
//  Program 2


#ifndef Warrior_hpp
#define Warrior_hpp



#include <stdio.h>
#include <string>
#include <stdlib.h>
#include "Actor.hpp"

using namespace std;

class Warrior: public Actor {
protected:
    vector <string> moveTypes= {"attackOne", "attackTwo"};
public:
    Warrior() = default;
    ~Warrior() = default;
    Warrior(int health, string type);
    vector <string> getMoves(){return moveTypes;}
};


#endif /* Warrior_hpp */
