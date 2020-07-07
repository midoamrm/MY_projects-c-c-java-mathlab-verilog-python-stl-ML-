#include<iostream>
#include<map>
#include<sstream>
#include<algorithm>
 
using namespace std;
#include<string>   
 
 
 
 
 
string inttostring(int x) {
 
 
 
	stringstream ss;
	ss << x;
	string str = ss.str();
 
 
	return str;
}
 
int main() {
 
	int n = 0;
 
	string out[100000];
	map<string, int> mm;
	map<string, int>::iterator it;
 
	cin >> n;
	cin.ignore();
	string s;
 
	for (int i = 0; i < n; i++) {
		getline(cin, s);
		if (i == 0) {
 
 
			mm[s] = 0;
 
			out[0] = "OK";
 
		}
 
		else {
 
 
			it = mm.find(s);
 
 
			if (!(it == mm.end())) {//name found
				mm[s] = mm[s] + 1;
 
				out[i] = s + inttostring(mm[s]);
 
			}
 
			else {//name not found
				mm[s] = 0;
 
				out[i] = "OK";
			}
 
 
		}
 
 
	}
 
	for (int j = 0; j < n; j++) {
		//cout << arr[j] << " ";
		cout << out[j] << "\n";
	}
 
 
 
 
 
}
