#include <iostream>
using namespace std;
 
int binarysearch(int arr[], int i, int h, int key) {
	int m = 0;
	int flG = 0;
	while (i <= h) {
 
		m = (i + h) / 2;
		if (arr[m] == key)
		{
			
			return m;
		}
		if (key < arr[m]) {
			h = m - 1;
 
		}
		else {
			i = m + 1;
 
 
		}
 
 
		for (int k = i; k < h + 1; k++) {
			if (k == i) {
				cout << arr[k];
			}
			else {
				cout << " " << arr[k];
			}
		}
		if (i <= h) {
			
			cout << "\n";
		}
	}
 
 
 
	return -1;
 
 
 
 
}
 
int main()
{
	int num = 0;
	int  numb = 0;
 
	cin >> num;
	cin >> numb;
	int arr[101];;
 
	for (int i = 0; i < numb; i++) {
 
		cin >> arr[i];
	}
 
	//int n = sizeof(arr) / sizeof(arr[0]);
 
 
 
 
	int reslut = binarysearch(arr, 0, numb - 1, num);
	if (reslut == -1) {
		cout << "NO" << "\n";
 
	}
	else {
 
 
		cout << "YES" << "\n";
	}
 
 
	return 0;
}
