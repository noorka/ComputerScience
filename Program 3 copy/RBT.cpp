//
//  RBT.cpp
//  Program 3
//
//  Created by Anna Kroon

#ifndef RBT_hpp
#define RBT_hpp

#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

enum Color {BLACK, RED};
//constructs the node
template <class T>
struct Node{
    Node *left;
    Node *right;
    Node *parent;
    bool color = RED;
    T key;
    
    
    Node(T key){
        this->key = key;
        left = right = parent = nullptr;
    }
};
//constructs the basic logic of a binary tree
template <class T>
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
template <typename T>
class RBTree {
protected:
    Node<T> *root;
    
public:
    RBTree(){root = nullptr;};
    
 //finds if each branch of the tree is balanced, returns a 0 for balances and a 1 for not
    int numBk(Node<T>* root){
        if(root == nullptr){
            return 1;
        }
        int leftBkHt = numBk(root->left);
        int rightBkHt = numBk(root->right);
        if(leftBkHt == 0) return leftBkHt;
        if(rightBkHt == 0) return rightBkHt;
        if(leftBkHt != rightBkHt) return 0;
        else{
            return leftBkHt + rightBkHt;
        }
    }
    //gets the tree's root
    Node<T>* getRoot(){
        return root;
    }
    //fixes up the three major violation cases for left and right sides of the tree
    void fix(Node<T> *&root, Node<T> *&dataptr){
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
    //finds a particular node in the tree by key
    Node<T>* find(T key, Node<T>* root){
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
    //overloads the find function to just require the key as a parameter
    Node<T>* find(T key){
        return find(key, root);
    }
    //rotates nodes to the left for violation fixes
    void rotateLeft(Node<T> *&root, Node<T> *&pt){
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
    //rotates nodes to the right for violation fixes
    void rotateRight(Node<T> *&root, Node<T> *&pt){
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
    //inserts a value into the tree then performs R/B fix ups
    void insert(T key){
        Node<T> *dataNode = new Node<T>(key);
        
        root = BSTinsert(root, dataNode);
        fix(root, dataNode);
        
    }
    //overload to print the tree with no parameters
    void dump(){
        dump(root, 1);
    }
    //prints out the tree with indentations to denote generation
    void dump(Node<T> *node, int tabs)
    {if (!node)
    {return;}
        dump(node->right, tabs + 1);
        for (int i = 0; i < tabs; ++i)
        {
            cout << "\t\t";
        }
        cout << node->key << " " << (node->color ? "Red" : "Black") << endl;
        dump(node->left, tabs + 1);
    }
};
//main with testing for strings and ints
int main(){
    RBTree<int> tree;
    tree.insert(12);
    tree.insert(22);
    tree.insert(7);
    tree.insert(11);
    tree.insert(24);
    tree.insert(1);
    tree.insert(18);
    tree.insert(30);
    
    tree.find(22);
    
    tree.dump();
    int trr = tree.numBk(tree.getRoot());
    cout << trr << endl;
    cout << "Found: " << tree.find(22)->key << (tree.find(22)->color ? " Red" : " Black") << endl;
    
    
    /*RBTree<string> tree;
     tree.insert("hi");
     tree.insert("bye");
     tree.insert("no");
     tree.insert("yes");
     tree.dump();*/
    
}


#endif /* RBT_hpp */
