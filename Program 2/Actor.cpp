//
//  Actor.cpp
//  Program 2


#include "Actor.hpp"
#include "MoveManager.hpp"

void Actor::hit(int damage, Actor* myPlayer){
    int currentHealth = myPlayer->health;
    int newHealth = currentHealth - damage;
    myPlayer->health = newHealth;
}

void Actor::heal(int amount, Actor* myPlayer){
    int currentHealth = myPlayer->health;
    int newHealth = currentHealth + amount;
    myPlayer->health = newHealth;
}
void Actor::doMove(MoveManager* mgr, string choiceType, Actor* player){
    MoveManager::MoveType myMoveType;
    Actor* actionPlayer;
    cout << this->getType() <<", (" << this->getHealth() << ") used: ";
    if (choiceType == "attackOne" ){
        myMoveType = MoveManager::MoveType::attackOne;
        actionPlayer = player;
        cout << "Attack One\n";
    }
    else if (choiceType == "attackTwo"){
        myMoveType = MoveManager::MoveType::attackTwo;
        actionPlayer = player;
        cout << "Attack Two\n";
    }
    else if (choiceType == "heal"){
        myMoveType = MoveManager::MoveType::heal;
        actionPlayer = this;
        cout << "Heal\n";
    }
    else{
        cout << "No Move\n";
    }
    if(actionPlayer){
        mgr->doMove(myMoveType, actionPlayer);
    }
}
string Actor::getType(){
    return type;
}
int Actor::getHealth(){
    return health;
}


