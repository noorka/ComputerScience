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
template <class T>
struct Node{
    Node<T> *left;
    Node<T> *right;
    Node<T> *parent;
    Node<T> *root;
    bool color = RED;
    T key;
    
    
    Node(T key){
        this->key = key;
        left = right = parent = nullptr;
    }
};
template <typename T>
Node<T>* BSTinsert(Node<T> *root, Node<T> *dataptr){
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
protected:
    //Node<T> *root; //why
    template <typename T>
    void rotateLeft(Node<T> *&, Node<T> *&);
    template <typename T>
    void rotateRight(Node<T> *&, Node<T> *&);
    template <typename T>
    void fix(Node<T> *&, Node<T> *&);
    
public:
    template <typename T>
    RBTree(){root = nullptr;};
    //~RBTree();
    void swap(bool color1, bool color2);
    template <typename T>
    void insert(T key);
    template <typename T>
    Node<T>* find (int key, Node<T>* root);
    template <typename T>
    Node<T>* find (int key);
    void dump();
    template <typename T>
    void dump(Node<T> *node, int tabs);
    template <typename T>
    int numBk(Node<T>* root);
    //void numBk(int amt);
    //int blackHeight(Node *root);
    template <typename T>
    Node<T>* getRoot();
    
};
/*void RBTree::numBk(int amt){
    numBk(root, amt);
}
*/
template <typename T>
int RBTree::numBk(Node<T>* root){
    int leftBkHt = numBk(root->left);
    int rightBkHt = numBk(root->right);
    if(root == nullptr){
        return 1;
    }
    if(leftBkHt == 0) return leftBkHt;
    if(rightBkHt == 0) return rightBkHt;
    if(leftBkHt != rightBkHt) return 0;
    else{
        return leftBkHt + rightBkHt;
    }
}
template <typename T>
Node<T>* RBTree::getRoot(){
    return root;
}
/*int blackHeight(Node *root){
    int leftBlackHeight = blackHeight(root->left);
    int rightBlackHeight = blackHeight(root->right);
    if (root == NULL) return 1;
    if (leftBlackHeight == 0) return leftBlackHeight;
    if (rightBlackHeight == 0) return rightBlackHeight;
    if (leftBlackHeight != rightBlackHeight) return 0;
    else return leftBlackHeight + (root->color ? 1 : 0);
}*/
template <typename T>
void RBTree::fix(Node<T> *&root, Node<T> *&dataptr){
    Node<T> *dad;
    Node<T> *grandDad;
    while((root!= dataptr) && (dataptr->color != BLACK) && (dataptr->parent->color != BLACK)){
        dad = dataptr->parent;
        grandDad = dataptr->parent->parent;
        
        if(dad == grandDad->left){
            Node<T>* uncle = grandDad->right;
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
            Node<T>* uncle = grandDad->left;
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
template <typename T>
Node<T>* RBTree::find(int key, Node<T>* root){
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
template <typename T>
Node<T>* RBTree::find(int key){
    return find(key, root);
}
template <typename T>
void RBTree::rotateLeft(Node<T> *&root, Node<T> *&pt){
    Node<T> *pt_right = pt->right;
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
template <typename T>
void RBTree::rotateRight(Node<T> *&root, Node<T> *&pt){
    Node<T> *pt_left = pt->left;
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
template <typename T>
void RBTree::insert(T key){
    Node<T> *dataNode = new Node<T>(key);
    
    root = BSTinsert(root, dataNode);
    fix(root, dataNode);
    
}
void RBTree::dump(){
    dump(root, 1);
}
template <typename T>
void RBTree::dump(Node<T> *node, int tabs)
{if (!node)
{return;}
    dump(node->right, tabs + 1);
    for (int i = 0; i < tabs; ++i)
    {
        cout << "\t\t";
    }
    cout << node->key << " " << (node->color ? "R" : "B") << endl;
    dump(node->left, tabs + 1);
}
int main(){
   /* RBTree tree;
    //Node* treeRoot;
    tree.insert(12);
    tree.insert(22);
    tree.insert(7);
    tree.insert(11);
    //tree.find(22);
    //tree.numBk(0);
    tree.dump();
    int trr = tree.numBk(tree.getRoot());
    cout << trr;
    //cout << "Found: " << tree.find(22)->key << (tree.find(22)->color ? "R" : "B") << endl;*/
}


#endif /* RBT_hpp */
