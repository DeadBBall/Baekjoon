#include <iostream>
using namespace std;

int arr[2][6];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	int longY = 0;
	int longX = 0;
	int shortY = 501;
	int shortX = 501;
	for(int i = 0; i < 6; i++)
	{
		cin >> arr[0][i] >> arr[1][i];
		if(arr[0][i] == 1 || arr[0][i] == 2)
			longX = max(longX, arr[1][i]);
		else
			longY = max(longY, arr[1][i]);
	}
	for(int i = 0; i < 5; i++)
	{
		if((arr[0][i] == 1 && arr[0][i + 1] == 3) || (arr[0][i] == 2 && arr[0][i + 1] == 4))
		{
			shortX = arr[1][i];
			shortY = arr[1][i + 1];
		}
		else if((arr[0][i] == 4 && arr[0][i + 1] == 1) || (arr[0][i] == 3 && arr[0][i + 1] == 2))
		{
			shortY = arr[1][i];
			shortX = arr[1][i + 1];
		}
	}
		if((arr[0][5] == 1 && arr[0][0] == 3) || (arr[0][5] == 2 && arr[0][0] == 4))
	{
		shortX = arr[1][5];
		shortY = arr[1][0];
	}
	else if((arr[0][5] == 4 && arr[0][0] == 1) || (arr[0][5] == 3 && arr[0][0] == 2))
	{
		shortY = arr[1][5];
		shortX = arr[1][0];
	}
	cout << (longX * longY - shortX * shortY) * n;
}