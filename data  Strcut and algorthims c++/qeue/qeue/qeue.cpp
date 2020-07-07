#include<iostream>
using namespace std;
class lin_qeue {
	struct node
	{
		int item;
		node* next;
	};
	node* head, * tail;
	node* mm;
	int length;
public:
	lin_qeue() {

		head = NULL;
		tail = NULL;
		length = 0;
	}
	bool isempty() {

		return length == 0;

	}

	void enqeue(int item2) {

		node* nxtptr = new node;
		nxtptr->item = item2;
		nxtptr->next = NULL;
		if (isempty()) {
			head = nxtptr;
			tail = nxtptr;
			length++;
		}
		else {

			tail->next = nxtptr;
			tail = nxtptr;
			length++;

		}

	}


	void deqeue(int& y) {

		y = head->item;


		if (length == 1) {
			head = NULL;
			tail = NULL;
			length = 0;

		}
		else {
			node* temp = new node;
			temp = head;
			head = head->next;
			temp->next = NULL;
			delete temp;
			length--;

		}

	}




	int getfront() {
		return head->item;
	}


	int getrear() {
		return tail->item;
	}

	void clear_q() {
		node* dealpr;
		while (head != NULL) {
			dealpr = head;
			head = head->next;
			delete dealpr;


		}
		length = 0;
		tail = NULL;



	}

	void print() {

		//node* cur;
	//cur = head;
		mm = head;

		cout << "[ ";

		while (mm != NULL)
		{
			cout << mm->item << "-";
			mm = mm->next;
		}

		cout << "]" << endl;

	}

};
int main() {
	int h = 0;
	lin_qeue g;
	g.enqeue(50);
	g.enqeue(990);
	g.enqeue(90);


	g.print();
	cout << g.getfront() << "\n";
	cout << g.getrear() << "\n";
	g.deqeue(h);
	cout << h << "\n";


	g.print();
	cout << g.getfront() << "\n";
	cout << g.getrear() << "\n";

	g.print();
	g.clear_q();
	g.print();




}