//
//  ICommand.hpp
//  Program 2
//
//  Created by Anna Kroon on 3/25/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef ICommand_hpp
#define ICommand_hpp

#include <stdio.h>
#include <iostream>
#include <vector>
#include "Stack.hpp"
using namespace std;

int state = 0;

enum CommandType{
    Increment,
    Decrement
};

class ICommand{
public:
    virtual void Execute()=0;
    virtual ~ICommand(){
        cout << "Command destructor" << endl;
    }
};

class IUndoableCommand: public ICommand{
public:
    virtual void Undo()=0;
};

class IncrementCommand: public IUndoableCommand {
public:
    void Execute(){
        state++;
    }
    
    void Undo(){
        state--;
    }
};

class DecrementCommand: public IUndoableCommand{
public:
    void Execute(){
        state--;
    }
    
    void Undo(){
        state++;
    }
};

#endif /* ICommand_hpp */
