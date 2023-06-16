#include <iostream>
using namespace std;

int n;
int dp[11];

void input()
{
	cin >> n;
}

int play(int num)
{
	if(num == 1)
	{
		return 0;
	}
	if(dp[num] != 0)
	{
		return dp[num];
	}
	int a = num / 2;
	int b = num - a;
	dp[num] += a * b;
	dp[num] += play(a);
	dp[num] += play(b);
	return dp[num];
}

int main()
{
	input();
	cout << play(n);
}