#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, in[1001], tmp[1001];
vector<int> v[1001], ans;

int main()
{
	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
		int cnt;
		cin >> cnt;
		for (int j = 0; j < cnt; j++)
		{
			cin >> tmp[j];
		}

		for (int j = 0; j < cnt - 1; j++)
		{
			for (int k = j + 1; k < cnt; k++)
			{
				v[tmp[j]].push_back(tmp[k]);
				in[tmp[k]]++;
			}
		}
	}

	queue<int> q;
	for (int i = 1; i <= n; i++)
	{
		if (in[i] == 0)
		{
			q.push(i);
			ans.push_back(i);
		}
	}
	if (q.empty())
	{
		cout << 0;
		return 0;
	}
	while (!q.empty())
	{
		int st = q.front();
		q.pop();
		for (int i = 0; i < v[st].size(); i++)
		{
			int end = v[st][i];
			in[end]--;
			if (in[end] == 0)
			{
				ans.push_back(end);
				q.push(end);
			}
		}
		if (q.empty() && ans.size() != n)
		{
			cout << 0;
			return 0;
		}
	}
	for (int i = 0; i < n; i++)
	{
		cout << ans[i] << "\n";
	}
}