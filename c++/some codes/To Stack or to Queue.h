#include <iostream>
#include <sstream> 
#include <stack>
#include<queue>
using namespace std;
int  main()
{
	
	int num = 0;
	int var = 0;
	string s;
	string s2;
	int x = 0;
	int temp = 2;
	
	cin>> num;
	
	queue<int> q;
	stack<int> st;
	for (int i = 0; i < num; i++) {
 
		cin >> s;
		
		if(!(s.compare("PUSH"))){
		
		   cin>>s2;
		
		
		}
 
		
 
		//cout << ss[0]<<"\n";
		if (!(s.compare("PUSH"))) {
 
 
			stringstream geek(s2);
 
			
 
			geek >> x;
			q.push(x);
			st.push(x);
 
			//	cout << x << "\n";
		}
		//cout << x << "\n";
		if ((!q.empty()) && (!st.empty())) {
			if (!(s.compare("POP"))) {
 
				q.pop();
				st.pop();
				//cout << "here" << "\n";
 
			}
 
 
		}
 
 
 
 
	}
 
 
	cin >> var;
	
 
	/*cout<<st.size()<<"\n";
	cout << q.size()<<"\n";
 
	cout << st.top() << "\n";
	cout << q.front() << "\n";
	*/
	
 
if(st.top() == q.front()) {
	
	cout << "UNKNOWN" << "\n";
		
	}
	else if (q.front() == var) {
		cout << "QUEUE" << "\n";
	}
 
 
	else if (st.top() == var) {
		
		cout << "STACK" << "\n";
	}
	else {
		cout << "UNKNOWN" << "\n";
 
	}
	return 0;
}