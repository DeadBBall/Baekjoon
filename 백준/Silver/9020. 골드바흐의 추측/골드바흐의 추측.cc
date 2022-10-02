#include <iostream>

using namespace std;
int main()
{
	int c[10001] = {0};
	c[1] = 1;
	for (int i = 2; i <= 10001; i++)
		for (int j = 2; j * i <= 10001; j++)
			c[i * j] = 1;
	int t;
	int n;
	int check;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> n;
		check = n / 2;
		for (int m = check; m > 0; m--)
		{
			if (c[m] != 1 && c[n - m] != 1)
			{
				cout << m << " " << n - m << endl;
				break;
			}
		}
	}
}