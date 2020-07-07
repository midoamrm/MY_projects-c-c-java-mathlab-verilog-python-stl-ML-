#include<iostream>
using namespace std;
template<class t>

//liked list;
class stack2 {

	struct node
	{
		t item;
		node* next;
	};
	node* top, * cur;
public:
	stack2() {
		top = NULL;
	}
	void push(t item2) {
		node* nodeptr = new node;
		nodeptr->item = item2;
		nodeptr->next = top;
		top = nodeptr;

	}
	void pop() {

		node* temp = new node;
		temp = top;
		top = top->next;
		temp = temp->next = NULL;
		delete temp;
	}
	void getpop(t& r) {
		r = top->item;
		node* temp2 = new node;
		temp2 = top;
		top = top->next;
		temp2 = temp2->next = NULL;
		delete temp2;

	}

	bool isempty() {

		return top == NULL;

	}
	t gettop() {

		return top->item;



	}

	void display() {
		cur = top;
		cout << "[ ";
		while (cur != NULL) {

			cout << cur->item << " ";
			cur = cur->next;
		}
		cout << "]" << "\n";

	}
};
int main() {
		int r;
	 stack2<int> s;
	 s.push(50);
	 s.push(55);
	 s.push(66);
	 s.display();
	 //cout << s.gettop()<<"\n";
	 s.getpop(r);
	 cout<<r<<"\n";
	 s.display();
	 s.pop();
	 s.display();

	 s.pop();
	 if (!s.isempty()) {
		 s.pop();
	 }
	 else
	 {
		 cout << "stack isempty" << "\n";
	 }
	 
}

