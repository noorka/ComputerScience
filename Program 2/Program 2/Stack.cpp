//
//  Stack.cpp
//  Program 2
//
//  Created by Anna Kroon on 3/20/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#include "Stack.hpp"
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
void Stack<A>::pop(){
    if(isEmpty()) throw StackEmptyException();
    top--;
}

template <typename A>
A Stack<A>::tipTop(){
    if(isEmpty()) throw StackEmptyException();
    return data[top];
}
