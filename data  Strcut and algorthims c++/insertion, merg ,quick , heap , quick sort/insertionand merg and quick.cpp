

#include <iostream>
using namespace std;
void insertion(int arr[],int n){
	for (int i = 0; i < n; i++) {//80 70 90
		int key = 0;
		key = arr[i];
		int j = i-1;
		while (j>=0 &&arr[j]>key)
		{

			arr[j + 1] = arr[j];

			j = j - 1;
		}


		arr[j + 1] = key;


	}






}
void merg(int arr[], int l, int m,int r) {//l=0;r=6;m=3
	int k = 0;
	int i =0; int j = 0;
	int n1 = m - l + 1;//n1=4
	int n2 = r - m;//n2=3
	int* L = new int[n1]; int* R = new int[n2];
	while (i < n1) {
		L[i] = arr[l + i];//0
		i++;
	}
	while (j < n2) {
		R[j] = arr[m + 1 + j];//4
		j++;
	}
	i = 0;
	j = 0;
	k = l;//deh ol elemnt;

	while (i < n1 && j<n2) {
        if(L[i]<=R[j]){
			arr[k] = L[i];
			i++;
		}
		else{
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	while(i < n1){
		arr[k] = L[i];
		i++; k++;
	}
	while(j < n2){
		arr[k] = R[j];
		j++;
		k++;
	}


}
void mergsort(int arr[],int l,int r) {
	if (l<r) {//l=r=0>>base for one element
		int m = l + (r - l) / 2;
	
		mergsort(arr,l,m);
		mergsort(arr,m+1,r);
		merg(arr, l, m, r);
	
	}


}
int partiation(int arr[],int l,int r) {
	int pivo = l;
	int i = l; int j = r;

	while (i < j) {
		do {
			i++;

		} while (arr[i] < arr[pivo]);

			do {
				j--;

			} while (arr[j] > arr[pivo]);

				if (i < j) { swap(arr[i],arr[j]); }

	}

	swap(arr[pivo], arr[j]);
	return j;
}
void quicksort(int arr[],int l,int r){
	if (l<r) {

		int pov = partiation(arr,l,r);
		quicksort(arr,l,pov);
		quicksort(arr,pov+1,r);

	}



}
void heapfiy(int arr[], int n,int i) {
	int lch = i * 2+1;//i>>1 !=0
	int rch = i * 2 + 2;
	int max = i;
	if (lch<n&&arr[lch] > arr[max])
		max = lch;
	if (rch<n && arr[rch] > arr[max])
		max = rch;
	if (max != i)
	{
		swap(arr[i],arr[max]);
		heapfiy(arr, n, max);
	}

	

}
void buildheap(int arr[],int n ) {
	for (int i = n/2-1; i >= 0; i--) {

		heapfiy(arr,n,i);
	}
}
void heapsort(int arr[],int n){
	buildheap(arr,n);

	for (int i = n - 1; i >= 0; i--) {
		swap(arr[0], arr[i]);
		heapfiy(arr, i, 0);
	}


}






void printarr(int num,int arr[]) {
	cout << "{-";
	for (int i = 0; i < num; i++) {
		cout << arr[i] << "-";
	}
	cout << "}" << "\n";
}

int main()
{

	//int arr[] ={2,1,5,7,6,8,9,55,3,66};

	//int num = sizeof(arr) / sizeof(arr[0]);

	//insertion(arr,num);
    //	mergsort(arr, 0, num - 1);
	//quicksort(arr,0,num-1);
	//heapsort(arr,num);
	
	//printarr(num,arr);

	

}

