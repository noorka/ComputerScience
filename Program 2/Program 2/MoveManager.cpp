//
//  MoveManager.cpp
//  Program 2


#include "MoveManager.hpp"


void MoveManager::doMove(MoveType moveType, Actor* actionPlayer){
    BattleMove* move;
    switch(moveType){
        case MoveType::attackOne:
            move = new AttackOne();
            break;
        case MoveType::attackTwo:
            move = new AttackTwo();
            break;
        case MoveType::heal:
            move = new Heal();
            break;
    }
    move->setPlayer(actionPlayer);
    move->execute();
    printMove(move, actionPlayer, moveType);
    try {
        stack.push(move);
    } catch (StackFullException sfe) {
        cout << "Move will not be undoable, stack is full.\n";
    }
}
void MoveManager::undoLastMove(){
    if(!stack.isEmpty()){
        auto move = stack.pop();
        move->undo();
        delete move;
    }
    else{
        printf("No moves to undo.\n");
    }
}

MoveManager::MoveManager(){
    stack = Stack<BattleMove*>();
}

MoveManager::~MoveManager(){
    while(!stack.isEmpty()){
        delete stack.tipTop();
        stack.pop();
    }
}
void MoveManager::printMove(BattleMove* move, Actor* actionPlayer, MoveType moveType){
    switch(moveType){
        case MoveType::attackOne:
            cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is hit with " << move->getActionAmt() << " damage.\n";
            break;
        case MoveType::attackTwo:
            cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is hit with " << move->getActionAmt() << " damage.\n";
            break;
        case MoveType::heal:
            cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is healed by " << move->getActionAmt() << " hp.\n";
            break;
    }
}
