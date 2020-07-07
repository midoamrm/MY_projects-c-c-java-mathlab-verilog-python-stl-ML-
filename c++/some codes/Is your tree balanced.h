#include<iostream>
using namespace std;
 
 
class bst {
 
	struct node {
		int data;
		node* lch;
		node* rch;
 
 
	};
	node* root = nullptr;
 
	int k = 0; int num = 0;
public:
	void  add(int data) {
		node* nodeptr = new node();
		nodeptr->data = data;
		num++;
		nodeptr->lch = nodeptr->rch = nullptr;
		if (root == nullptr) {
			root = nodeptr;
			return;
		}
		node* temp = root;
		node* parent = nullptr;
		while (temp != nullptr) {
 
			parent = temp;
			if (data <= temp->data) {
				temp = temp->lch;
			}
			else {
 
 
				temp = temp->rch;
			}
		}
 
 
		if (data <= parent->data) {
			parent->lch = nodeptr;
		}
		else {
			parent->rch = nodeptr;
		}
	}
	int flag[1001];
	int flag2 = 0;
	int blanced() {
		//cout << num << "\n";
		return blancd(root);
 
	}
	
	int blancd(node *root){
 
		
		if (root==nullptr) {
			return -1;
 
	   }
		
		
		
			int lh = blancd(root->lch);
 
			int rh = blancd(root->rch);
			flag[k] = ((lh)-(rh));
	    //		cout << flag[k] << " ";
			k++;
			
			return lh > rh ? lh + 1 : rh + 1;
 
		
			
			
	
	
	
	
	}
 
 
	bool blancebst() {
		blanced();
		for (int n = 0; n < num; n++) {
 
			if (flag[n] <-1 || flag[n] > 1) {
				return false;
			 
			}
 
		}
 
		return true;
 
	}
	
	//node* temp1=root;
	//node* temp2 = nullptr;
 
	void printinoreder() {
 
		inorder(root);
	}
	void inorder(node* root) {
		if (root != nullptr) {
		
			inorder(root->lch);
			cout <<" "<<root->data;
			inorder(root->rch);
 
 
 
 
 
		}
 
 
 
 
 
	}
 
 
 
 
 
 
};
 
 
int main() {
	bst s;
	int num=0;
	int x = 0;
	cin >> num;
	for (int i = 0; i < num ; i++) {
		cin >> x;
		s.add(x);
 
 
	}
 
	
	
	
	if (s.blancebst()) {
		cout << "YES" << "\n";
	}
	else{
		cout << "NO" << "\n";
	}
	//cout << s.blanced();
	return 0;
}