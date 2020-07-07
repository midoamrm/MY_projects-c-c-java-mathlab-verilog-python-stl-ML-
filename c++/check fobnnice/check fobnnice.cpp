
#include <iostream>
using namespace std;
void fobanci(int num) {
	int v1 = 0;//0 1 1 2 3 5
	int v2 = 1;
	int sum = 0;
	if (num < 0) {
		num = num * (-1);
		cout << " you enter negtive num and program is change it to psstive *___*" << endl;

	}
	if (num == 1) {
		cout << v1 << endl;
	}
	else if (num == 2) {
		cout << v1<<" "<<v2 << endl;

	}
	else {
		cout << 0<<" ";
		cout << 1<<" ";
		for (int i = 3; i < num + 1; i++) {

			
			sum = v1 + v2;
			cout << sum<<" ";
			v1 = v2;
			v2 = sum;


		}




	}
}

int main()
{
	int num;
	cin >> num;
	

	fobanci(num);



	system("PAUSE");
	return 0;

}

