//
//  RBT.hpp
//  Program 3
//
//  Created by Anna Kroon on 5/7/18.
//  Copyright © 2018 Anna Kroon. All rights reserved.
//

#ifndef RBT_hpp
#define RBT_hpp

#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;
enum Color {BLACK, RED};

struct Node{
    Node *left;
    Node *right;
    Node *parent;
    bool color;
    int key;
    
    
    Node(int key){
        this->key = key;
        left = right = parent = nullptr;
    }
};

Node* BSTinsert(Node *root, Node *dataptr){
    if(root == nullptr){
        return dataptr;
    }
    if(dataptr ->key < root->key){
        root->left = BSTinsert(root ->left, dataptr);
        root->left->parent = root;
    }
    if(dataptr ->key > root->key){
        root->right = BSTinsert(root ->right, dataptr);
        root->right->parent = root;
    }
    return root;
}

class RBTree {
    
public:
    RBTree(){root = nullptr;};
    //~RBTree();
    void swap(bool color1, bool color2);
    void insert(int key);
    Node* find (int key, Node* root);
    Node* find (int key);
    void Dump();
    void Dump(Node *node, int tabs);
    
protected:
    Node *root;
    void rotateLeft(Node *&, Node *&);
    void rotateRight(Node *&, Node *&);
    void fix(Node *&, Node *&);
};
void RBTree::swap(bool color1, bool color2){
    bool temp;
    temp = color1;
    color1 = color2;
    color2 = temp;
}
void RBTree::fix(Node *&root, Node *&dataptr){
    Node *dad;
    Node *grandDad;
    while((root!= dataptr) && (dataptr->color != BLACK) && (dataptr->parent->color != BLACK)){
        dad = dataptr->parent;
        grandDad = dataptr->parent->parent;
        
        if(dad == grandDad->left){
            Node* uncle = grandDad->right;
            if(uncle != NULL && uncle->color == RED){
                uncle->color = BLACK;
                dad->color = BLACK;
                grandDad->color = RED;
                dataptr = grandDad;
            }
            else{
                if(dataptr == dad->right){
                    rotateLeft(root, dad);
                    dataptr = dad;
                    dad = dataptr->parent;
                }
                rotateRight(root, grandDad);
                grandDad->color = RED;
                dad->color = BLACK;
                dataptr = dad;
            }
        }
        else{
            Node* uncle = grandDad->left;
            if(uncle != NULL && uncle->color == RED){
                uncle->color = BLACK;
                dad->color = BLACK;
                grandDad->color = RED;
                dataptr = grandDad;
            }
            else{
                if(dataptr == dad->left){
                    rotateRight(root, dad);
                    dataptr = dad;
                    dad = dataptr->parent;
                }
                rotateLeft(root, grandDad);
                grandDad->color = RED;
                dad->color = BLACK;
                dataptr = dad;
            }
        }
    }
    root->color = BLACK;
}

Node* RBTree::find(int key, Node* root){
    if(root == nullptr){
        return nullptr;
    }
    if(root->key == key){
        return root;
    }
    if(key < root->key) {
        return find(key, root->left);
    }
    return find(key, root->right);
}

Node* RBTree::find(int key){
    return find(key, root);
}

void RBTree::rotateLeft(Node *&root, Node *&pt){
    Node *pt_right = pt->right;
    pt->right = pt_right->left;
    
    if (pt->right != NULL){
        pt->right->parent = pt;
    }
    pt_right->parent = pt->parent;
    
    if (pt->parent == NULL){
        root = pt_right;
    }
    else if (pt == pt->parent->left){
        pt->parent->left = pt_right;
    }
    else{
        pt->parent->right = pt_right;
    }
    pt_right->left = pt;
    pt->parent = pt_right;
}

void RBTree::rotateRight(Node *&root, Node *&pt){
    Node *pt_left = pt->left;
    pt->left = pt_left->right;
    
    if (pt->left != NULL){
        pt->left->parent = pt;
    }
    pt_left->parent = pt->parent;
    
    if (pt->parent == NULL){
        root = pt_left;
    }
    else if (pt == pt->parent->left){
        pt->parent->left = pt_left;
    }
    else{
        pt->parent->right = pt_left;
    }
    pt_left->right = pt;
    pt->parent = pt_left;
}
void RBTree::insert(int key){
    Node *dataNode = new Node(key);
    
    root = BSTinsert(root, dataNode);
    fix(root, dataNode);
    
}
void RBTree::Dump(){
    Dump(root, 1);
}
void RBTree::Dump(Node *node, int tabs)
{if (!node)
{return;}
    Dump(node->left, tabs + 1);
    for (int i = 0; i < tabs; ++i)
    {
        cout << "\t\t";
    }
    cout << node->key << " " << (node->color ? "B" : "R") << endl;
    Dump(node->right, tabs + 1);
}
int main(){
    RBTree tree;
    //Node* treeRoot;
    tree.insert(12);
    tree.insert(15);
    tree.insert(22);
    tree.insert(7);
    tree.insert(11);
    //tree.find(22);
    tree.Dump();
    cout << "Found: " << tree.find(22)->key << (tree.find(22)->color ? "B" : "R") << endl;
}
//rotateLeft
//rotateRight
//fix
//color setting?


#endif /* RBT_hpp */
