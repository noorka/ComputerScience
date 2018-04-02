//
//  Stack.hpp
//  Program 2


#ifndef Stack_hpp
#define Stack_hpp

#define MAX_LENGTH 50

#include <stdio.h>
#include <string>
#include <stdlib.h>

using namespace std;

class StackEmptyException{};
class StackFullException{};

template <typename A>
class Stack{
private:
    A* data;
    int top;
    int maxLength;
    
public:
    Stack() :maxLength{MAX_LENGTH}{
        data = new A[maxLength];
        top = -1;
    }
    Stack(int len):maxLength{len}{
        data = new A[maxLength];
        top = -1;
    }
    
    void makeEmpty();
    bool isEmpty();
    bool isFull();
    void push(A item);
    A pop();
    A tipTop();
    
};

template <typename A>
void Stack<A>::makeEmpty(){
    top = -1;
}

template <typename A>
bool Stack<A>::isEmpty(){
    return top == -1;
}
template <typename A>
bool Stack<A>::isFull(){
    return top == maxLength -1;
}

template <typename A>
void Stack<A>::push(A item){
    if(isFull()) throw StackFullException();
    data[++top] = item;
}

template <typename A>
A Stack<A>::pop(){
    if(isEmpty()) throw StackEmptyException();
    return data[top--];
    
}

template <typename A>
A Stack<A>::tipTop(){
    if(isEmpty()) throw StackEmptyException();
    return data[top];
}

#endif /* Stack_hpp */
