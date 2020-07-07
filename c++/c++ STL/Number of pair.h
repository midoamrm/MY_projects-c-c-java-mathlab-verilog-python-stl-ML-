#include<iostream>
#include<unordered_map>
using namespace std;
 
 
int getPairsCount(int arr[], int n, int sum)
{
	unordered_map<int, int> m;
 
	
	for (int i = 0; i < n; i++)
		m[arr[i]]++;
 
	int twice_count = 0;
 
	
	for (int i = 0; i < n; i++)
	{
		twice_count += m[sum - arr[i]];
 
		
		if (sum - arr[i] == arr[i])
			twice_count--;
	}
 
	
	return twice_count / 2;
}
 
 
int main()
{
	int arr[100001];
	int n = 0;
	int sum = 10;
	cin >> n;
	cin >> sum;
	for (int i = 0; i < n; i++) {
 
		cin >> arr[i];
 
	}
	cout<<getPairsCount(arr, n, sum)<<"\n";
	
	
	
