#include <iostream>
#include <cstdlib>
using namespace std;

int n, score[20][20], sum = 0, sum2 = 0, ans = 9999999;
bool visit[20];

void solve(int cnt, int start)
{
	if(cnt == n / 2)
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			{
				if(visit[i] && visit[j])
					sum += score[i][j];
				else if(!visit[i] && !visit[j])
					sum2 += score[i][j];
			}
		int diff = abs(sum - sum2);
		if(diff < ans)
			ans = diff;
		sum = 0;
		sum2 = 0;
		return;
	}
	for(int i = start; i < n; i++)
	{
		if(visit[i])
			continue;
		visit[i] = 1;
		solve(cnt + 1, i + 1);
		visit[i] = 0;
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			cin >> score[y][x];
	visit[0] = 1;
	solve(1, 1);
	cout << ans;
}