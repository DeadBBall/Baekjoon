#include <iostream>
using namespace std;

int num = 0;
int ans[10], myAns[10];

void solve(int n)
{
	if(n == 10)
	{
		int score = 0;
		for(int i = 0; i < 10; i++)
			if(ans[i] == myAns[i])
				score++;
		if(score >= 5)
			num++;
		return;
	}
	for(int i = 1; i <= 5; i++)
	{
		if(n == 0 || n == 1 || myAns[n - 2] != myAns[n - 1] || myAns[n - 1] != i || myAns[n - 2] != i)
		{
			myAns[n] = i;
			solve(n + 1);
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for(int i = 0; i < 10; i++)
		cin >> ans[i];
	solve(0);
	cout << num;
}