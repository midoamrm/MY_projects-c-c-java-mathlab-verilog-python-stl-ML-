#include <iostream>
using namespace std;
int main()
{
    
 
	int count[1001] = { 0 };
	int x = 0;
	int maxcount = 0;
	int maxindex = 0;
	int num = 0;
   int 	in[100000];
   cin >> num;
	for (int p = 0; p < num; p++) {
		cin >> in[p];
 
	}
	for (int i = 0; i < num; i++) {
 
		x = in[i];
 
		count[x]++;
 
	}
	maxcount = 0;
	for (int h = 0; h < 1001; h++) {
 
		if (count[h] >= maxcount) {
			maxcount = count[h];
			maxindex = h;
 
 
		}
 
	}
	cout << maxindex;
	return 0;
}