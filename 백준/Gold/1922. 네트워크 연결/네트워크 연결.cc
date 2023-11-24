#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct line
{
	int i;
	int j;
	int dist;
};

int v, e, parent[10001], ans;
vector<line> lineV;

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
	x = find(x);
	y = find(y);
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
	x = find(x);
	y = find(y);
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
		if (cnt == v - 1)
		{
			break;
		}
		int x = find(lineV[k].i);
		int y = find(lineV[k].j);
		int d = lineV[k].dist;
		if (x == y)
		{
			continue;
		}
		Union(x, y);
		ans += d;
		cnt++;
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	kruskal();
	cout << ans;
}