//
//  main.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/19/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include <iostream>
#include <time.h>
#include <stdlib.h>
#include "Runner.hpp"


int main(int argc, const char * argv[]) {
    srand((int)time(NULL));
    Runner r = Runner();
    int player;
    int choice;
    do {
        r.printPlayer();
        cin >> player;
    }
    while( r.inputOne(player) > 0 );
    
    do {
        r.printOpponent();
        cin >> player;
    }
    while( r.inputTwo(player) > 0 );
    
    while(r.isDead(r.getPlayerOne())||r.isDead(r.getPlayerTwo()) == false){
        r.printChoice();
        cin >> choice;
        r.menuChoice(choice);
        r.printAction();
    }
    if(r.isDead(r.getPlayerOne()) == true){
        cout << "\nPlayer (" << r.getPlayerOne()->getType() << ")is dead.\n";
        cout << "Game Over\n";
    }
       else if(r.isDead(r.getPlayerTwo()) == true){
           cout << "\nOpponent (" << r.getPlayerTwo()->getType() << ")is dead.\n";
           cout << "Game Over\n";
       }
    return 0;
}
