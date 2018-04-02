//
//  Ghost.hpp
//  Program 2


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

#endif /* Ghost_hpp */
