#include <iostream>
#include <vector>
using namespace std;

int lowDp[3], highDp[3];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for(int i = 0; i < 3; i++)
	{
		int a;
		cin >> a;
		highDp[i] = a;
		lowDp[i] = a;
	}
	for(int i = 1; i < n; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		int tmpDp[3];
		tmpDp[0] = highDp[0] > highDp[1] ? highDp[0] : highDp[1];
		tmpDp[1] = tmpDp[0] > highDp[2] ? tmpDp[0] : highDp[2];
		tmpDp[2] = highDp[1] > highDp[2] ? highDp[1] : highDp[2];
		highDp[0] = tmpDp[0] + a;
		highDp[1] = tmpDp[1] + b;
		highDp[2] = tmpDp[2] + c;
		tmpDp[0] = lowDp[0] < lowDp[1] ? lowDp[0] : lowDp[1];
		tmpDp[1] = tmpDp[0] < lowDp[2] ? tmpDp[0] : lowDp[2];
		tmpDp[2] = lowDp[1] < lowDp[2] ? lowDp[1] : lowDp[2];
		lowDp[0] = tmpDp[0] + a;
		lowDp[1] = tmpDp[1] + b;
		lowDp[2] = tmpDp[2] + c;
	}
	int high = 0, low = 900001;
	for(int i = 0; i < 3; i++)
	{
		high = high > highDp[i] ? high : highDp[i];
		low = low < lowDp[i] ? low : lowDp[i];
	}
	cout << high << " " << low;
}