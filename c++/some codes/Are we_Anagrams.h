#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
void merg(char* A, char* L, int* leftcount, char* R, int* rightcount) {
 
	int i, k, j;
	i = 0;//L
	j = 0;//r
	k = 0;//A
 
	while (i < leftcount && j < rightcount) {
 
 
		if (L[i] < R[j]) {
			A[k++] = L[i++];
 
		}
		else {
			A[k++] = R[j++];
		}
 
 
 
 
	}
 
 
	while (i < leftcount) { A[k++] = L[i++]; }
 
	while (j < rightcount) { A[k++] = R[j++]; }
 
}
 
 
 
 
 
void mergsort(char* A, int n) {
 
	int mid, i;
	char* L, * R;
	if (n < 2)return;
	mid = n / 2;
	L = (char*)malloc(mid * sizeof(int));
	R = (char*)malloc((n - mid) * sizeof(int));
 
	for (i = 0; i < mid; i++) {
		L[i] = A[i];
	}
 
	for (i = mid; i < n; i++) {
		R[i - mid] = A[i];
	}
 
	mergsort(L, mid);
	mergsort(R, n - mid);
	merg(A, L, mid, R, n - mid);
 
	free(L);
	free(R);
 
 
}