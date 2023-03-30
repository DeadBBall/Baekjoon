#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

struct line
{
	int i;
	int j;
	int dist;
};

int v, e, parent[100001], ans;
vector<line> lineV;
bool visit[1000000];

int cmp(line a, line b)
{
	return a.dist < b.dist;
}

int find(int x)
{
	if (parent[x] == x)
	{
		return x;
	}
	return parent[x] = find(parent[x]);
}

void Union(int x, int y)
{
	if (x == y)
	{
		return;
	}
	if (x > y)
	{
		parent[x] = y;
	}
	else
	{
		parent[y] = x;
	}
}

bool isUnion(int y, int x)
{
	if (y == x)
	{
		return true;
	}
	return false;
}

void input()
{
	cin >> v >> e;
	for (int i = 1; i <= v; i++)
	{
		parent[i] = i;
	}
	for (int i = 0; i < e; i++)
	{
		int x, y, z;
		cin >> x >> y >> z;
		lineV.push_back({ x, y, z });
	}
	sort(lineV.begin(), lineV.end(), cmp);
}

void kruskal()
{
	int cnt = 0;
	for (int k = 0; k < e; k++)
	{
		int x = find(lineV[k].i);
		int y = find(lineV[k].j);
		int d = lineV[k].dist;
		if (x == y)
		{
			continue;
		}
		visit[k] = true;
		Union(x, y);
		cnt++;
		ans += d;
	}
	for (int i = e - 1; i >= 0; i--)
	{
		if (visit[i])
		{
			ans -= lineV[i].dist;
			break;
		}
	}
	return;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	kruskal();
	cout << ans;
}