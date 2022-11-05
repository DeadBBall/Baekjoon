#include <iostream>
using namespace std;

int n, m, arr[9] = {0};
bool visit[9];

void dfs(int cnt)
{
	if(cnt == m)
	{
		for(int i = 0; i < m; i++)
		cout << arr[i] << ' ';
		cout << '\n';
		return;
	}
	for(int i = 1; i <= n; i++)
	{
		if(!visit[i])
		{
			if(cnt == 0 || (cnt != 0 && arr[cnt - 1] < i))
			{
				visit[i] = true;
				arr[cnt] = i;
				dfs(cnt + 1);
				visit[i] = false;
			}
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	dfs(0);
}