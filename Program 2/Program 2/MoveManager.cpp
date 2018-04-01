//
//  MoveManager.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "MoveManager.hpp"


/*
 Analogous to our CommandManager class. Will hold on to a stack (use the template implementation of stack from the lecture code on Templates) of BattleMove*'s and will be referenced by every actor. Whenever an actor performs a move, it will go through the MoveManager's method so that history is recorded on the stack.
 Move manager will have DoMove() and UndoLastMove() methods defined, a constructor to initialize a stack, as well as a destructor to delete all the BattleMove*'s still in the stack. A MoveManager's DoMove will
 */

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
    printMove(move, actionPlayer);
    stack.push(move);
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
void MoveManager::printMove(BattleMove* move, Actor* actionPlayer){
    string moveName = typeid(move).name();
    if(moveName.find("One") > -1){
        cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is hit with" << move->getActionAmt() << " damage.\n";
    }
    else if(moveName.find("Two")> -1){
       cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is hit with" << move->getActionAmt() << " damage.\n";
    }
    else if(moveName.find("Heal") > -1){
        cout << actionPlayer->getType() << ", (" << actionPlayer->getHealth() << ") is healed by" << move->getActionAmt() << " hp.\n";
    }
}
