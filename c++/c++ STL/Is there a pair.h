include<iostream>
#include<algorithm>
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
 
 
 
 
bool hasArrayTwoCandidates(int A[], int arr_size,
	int sum)
{
	int l, r;
 
	
	sort(A, A + arr_size);
 
	
	l = 0;
	r = arr_size - 1;
	while (l < r) {
		if (A[l] + A[r] == sum)
			return 1;
		else if (A[l] + A[r] < sum)
			l++;
		else // A[i] + A[j] > sum 
			r--;
	}
	return 0;
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
	//cout<<getPairsCount(arr, n, sum)<<"\n";
	if (hasArrayTwoCandidates(arr,n,sum)) {
		cout << "YES" << "\n";
	}
	
	else {
 
		cout << "NO" << "\n";
	}
}
