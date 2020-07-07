#include <iostream>
#include<string>
#include<stack>
using namespace std;
bool areequle(string open, string close) {
	string tag1;
	string tag2;
	tag1 = open.substr((open.find("<")) + 1);
	tag2 = close.substr((close.find("/")) + 1);
 
	if ((open[0] == '<' && open[open.length() - 1] == '>') && (close[0] == '<' && close[close.length() - 1] == '>' && close
		[1] == '/')) {
		if (!tag1.compare(tag2)) {
			//cout << "here555";
			
			return true;
		}
		else {
			return false;
		}
		
	}
	else {
 
		return false;
 
	}
}
 
 
bool areblancexml(string s[], int n) {
 
	stack<string> st;
	int flag = 0;
	for (int i = 0; i < n; i++)
	{
 
		if (s[i][0] == '<' && s[i][s[i].length() - 1] == '>' && s[i][1] != '/') {
 
			st.push(s[i]);
			//	cout << " here" << "\n";
		}
 
		else if (s[i][0] == '<' && s[i][s[i].length() - 1] == '>' && s[i][1] == '/') {
 
			if (st.empty() || !areequle(st.top(), s[i]))
			{
				//	cout << " here2" << "\n";
				return false;
			}
			else { st.pop(); }
 
			//cout << " here3" << "\n";
		}
		else if (i == n - 1 || i == 0) {
			return false;
		}
 
 
	}
	//cout << st.size() << "\n";
 
	if (st.empty()) {
		return true;
	}
	else {
		return false;
 
	}
 
}
int main()
{
	
	string input[1004];
	int num = 0;
	cin >> num;
	for (int i = 0; i < num; i++) {
 
		cin >> input[i];
 
 
	}
	
	//cout << tag1 << "\n" << tag2 << "\n";
 
	
 
   if (areblancexml(input, num)) {
		cout << "YES" << "\n";
	}
	else {
 
		cout << "NO" << "\n"; 
	}
	
 
 
}