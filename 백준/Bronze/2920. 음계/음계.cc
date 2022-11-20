#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int arr[8];
	int flag = 0;
	for(int i = 0; i < 8; i++)
	{
		cin >> arr[i];
		if(arr[i] == i + 1)
		{
			if(flag == 0)
				flag = 1;
			else if(flag == 2)
				flag = 3;
		}
		else if(arr[i] == 8 - i)
		{
			if(flag == 0)
				flag = 2;
			else if (flag == 1)
				flag = 3;
		}
		else
			flag = 3;
	}
	if(flag == 1)
		cout << "ascending";
	else if(flag == 2)
		cout << "descending";
	else
		cout << "mixed";
}