#include<iostream>
#include<string>
#include<stack>
#include <sstream> 
using namespace std;
string arr[1000];
int removeDupWord(string str)
{
	int t = -1;
 
 
	string word = "";
	for (auto x : str)
	{
		if (x == ' ')
		{
			//cout << word << endl;
 
			//cout << x<<"\n";
			t++;
			arr[t] = word;
			//cout << t << "\n";
			word = "";
		}
		else
		{
			word = word + x;
		}
	}
	//cout << word << endl;
	arr[t + 1] = word;
	//cout << t + 1 << "\n";
 
	return t + 2;
}
 
 
bool isnumber(string s) {
	stringstream geek(s);
	int x = 0;
	geek >> x;
	if (x != 0) {
		if (-100 <= x && x <= 100) {
 
			return true;
		}
		else {
			return false;
		}
	}
 
	else if(!s.compare("0") ){
 
		return true;
	}
	else {
		return false;
 
 
	}
 
}
 
string operation(string op2, string op1, string oper) {
 
	if (!oper.compare("*")) {
		return "(" + op1 + "*" + op2 + ")";
	}
	else if (!oper.compare("/")) { return"(" + op1 + "/" + op2 + ")"; }
	else if (!oper.compare("-")) { return"(" + op1 + "-" + op2 + ")"; }
	else if (!oper.compare("+")) { return"(" + op1 + "+" + op2 + ")"; }
	
	else if (!oper.compare("^")) { return"(" + op1 + "^" + op2 + ")"; }
 
 
}
 
 
 
 
 
// Driver function 
int main()
{
	int flag = 0;
	int y = 0;
	string str;//"3 6 /";
	//cin >> str;
	getline(cin, str);
	//cout << str;
	y = removeDupWord(str);
	/*for (int i = 0; i < y; i++) {
		cout << arr[i] << "\n";
	}*/
	stack<string> st;
 
	for (int k = 0; k < y; k++) {
 
		if (isnumber(arr[k])) {
 
 
			st.push(arr[k]);
 
		}
		else {
 
			if (arr[k].compare("tan")) {
				
				string op2;
	          	if (!st.empty()) {
					op2 = st.top();
					st.pop();
					//cout << "no" << "\n";
					//break;
				}
				else {
					cout << "NO" << "\n";
					flag = 1;
				break;
 
 
				}
				string op1;
				
				if (!st.empty()) {
					op1 = st.top();
					st.pop();
					
				}
 
				else {
					cout << "NO" << "\n";
					flag = 1;
					break;
 
				}
				string rl = operation(op2, op1, arr[k]);
				//cout << "re" << "\n";
 
				st.push(rl);
				//cout << st.top();
			}
 
			else {
				string op22;
				if (!st.empty()) {
					op22 = st.top();
					st.pop();
				}
				else{
					cout << "NO" << "\n";
					flag = 1;
					break;
				}
				//cout << "re" << "\n";
				string rll ="("+ arr[k] + "(" + op22 + ")"+")";
				st.push(rll);
 
			}
 
 
		}
 
 
 
 
 
 
	}
 
 
 
	if ((st.size() != 1 && flag != 1)) {
		cout << "NO" << "\n";
		
 
 
	}
	else{
	if (!st.empty()) {
		cout << st.top() << "\n";
	}
	}
	//st.pop();
	//cout << st.top() << "\n";
 
 
 
	return 0;
}