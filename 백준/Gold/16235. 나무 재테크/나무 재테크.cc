#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

struct tree
{
	int year;
	int y;
	int x;
	// bool operator<(const tree t) const
	// {
	// 	return this->year > t.year;
	// }
};

int n, m, k, board[11][11], nourishment[11][11];
int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
priority_queue<tree> lTree;
priority_queue<tree> dTree;
vector<int> ltre[11][11];
vector<tree> dtre;
vector<tree> tmp;

void input()
{
	cin >> n >> m >> k;
	for (int y = 1; y <= n; y++)
	{
			for (int x = 1; x <= n; x++)
			{
					board[y][x] = 5;
					cin >> nourishment[y][x];
			}
	}
	for (int i = 0; i < m; i++)
	{
			int x, y, year;
			cin >> y >> x >> year;
			ltre[y][x].push_back(year);
	}
}

void checkTime()
{
	for (int j = 0; j < k; j++)
	{
			dtre.clear();
			tmp.clear();
			// priority_queue<tree> tmp;
			// while (!lTree.empty())
			// {
			// 		tree now = lTree.top();
			// 		lTree.pop();
			// 		// cout << "\n" << now.year;
			// 		if (board[now.y][now.x] >= now.year)
			// 		{
			// 				board[now.y][now.x] -= now.year;
			// 				now.year++;
			// 				tmp.push(now);
			// 		}
			// 		else
			// 		{
			// 				dTree.push(now);
			// 		}
			// }
			for(int y = 1; y <= n; y++)
			{
				for(int x = 1; x <= n; x++)
				{
					int length = ltre[y][x].size();
					if(length == 0)
					{
						continue;
					}
					sort(ltre[y][x].begin(), ltre[y][x].end());
					for(int q = 0; q < length; q++)
					{
						if (board[y][x] >= ltre[y][x][q])
						{
							board[y][x] -= ltre[y][x][q];
							ltre[y][x][q]++;
							tmp.push_back({ltre[y][x][q], y, x});
						}
						else
						{
							dtre.push_back({ltre[y][x][q], y, x});
						}
					}
					ltre[y][x].clear();
				}
			}
			// cout << "\n";
			// cout << "\n";
			// for (int y = 1; y <= n; y++)
			// {
			// 		for (int x = 1; x <= n; x++)
			// 		{
			// 			cout << board[y][x] << " ";
			// 		}
			// 		cout << "\n";
			// }

			// ltre = tmp;


			// while (!dTree.empty())
			// {
			// 		tree now = dTree.top();
			// 		dTree.pop();
			// 		board[now.y][now.x] += now.year / 2;
			// }
			for(int i = 0; i < dtre.size(); i++)
			{
				tree now = dtre[i];
				board[now.y][now.x] += now.year / 2;
			}

			for(int i = 0; i < tmp.size(); i++)
			{
				tree now = tmp[i];

				if(now.year % 5 == 0 && now.year > 0)
				{

					for(int q = 0; q < 8; q++)
					{
						int ny = now.y + dy[q];
						int nx = now.x + dx[q];
						if(ny < 1 || nx < 1 || ny > n || nx > n)
						{
							continue;
						}
						ltre[ny][nx].push_back(1);
					}
				}
				ltre[now.y][now.x].push_back(now.year);
			}
			// for(int y = 1; y <= n; y++)
			// {
			// 	for(int x = 1; x <= n; x++)
			// 	{
			// 		int length = ltre[y][x].size();
			// 		if(length == 0)
			// 		{
			// 			continue;
			// 		}
			// 		for(int q = length - 1; q >= 0; q--)
			// 		{
			// 			int year = ltre[y][x][q];
			// 			ltre[y][x].pop_back();
			// 			for(int i = 0; i < 8; i++)
			// 			{
			// 				int ny = y + dy[i];
			// 				int nx = x + dx[i];
			// 				if(ny < 1 || nx < 1 || ny > n || nx > n)
			// 				{
			// 					continue;
			// 				}
			// 			}

			// 		}
			// 	}
			// }
			for (int y = 1; y <= n; y++)
			{
				for (int x = 1; x <= n; x++)
				{
					board[y][x] += nourishment[y][x];
				}
			}

			// cout << "\n";
			// for (int y = 1; y <= n; y++)
			// {
			// 		for (int x = 1; x <= n; x++)
			// 		{
			// 			cout << board[y][x] << " ";
			// 		}
			// 		cout << "\n";
			// }

	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	checkTime();
	int ans = 0;
	for(int y = 1; y <= n; y++)
	{
		for(int x = 1; x <= n; x++)
		{
			ans += ltre[y][x].size();
		}
	}
	cout << ans;
}
