#include <iostream>
#include<queue>
#include<map>
#include<vector>
#include<string>
using namespace std;
 
 
int main() {
 
	queue<int> proesses;
	priority_queue<int,vector<int>,greater<int>> serves;
	float waittime = 0;
	int  m= 0;
	int n = 0;
	cin >> m;
	cin >> n;
	int nn = 0;
	int b = 0;
	int time[100000];
	
	for (int j = 0; j < n; j++) {
 
		cin >> nn;
		proesses.push(nn);
 
	
	}
	
	for (int i = 0; i < m; i++) {
 
		serves.push(0);
	}
 
	for (int k = 0; k < n; k++) {
		waittime = waittime + serves.top();
		b = serves.top() + proesses.front();  //s>>0+10 s>>0+20 S>>10+15 s>>20+20
		//cout << "s>>" << serves.top()<<"+"<< proesses.front();
		serves.pop();
		proesses.pop();
 
		//cout << "b"<<b<<"";
		serves.push(b);
 
	}
//	cout << "b" << b << "";
	int ii = 0;
	while (!serves.empty())
	{ 
		time[ii]= serves.top();
		serves.pop();
		ii++;
 
	}
 
cout <<time[m-1]<<" "<<(float)waittime/(float)n << "\n";
	
}
