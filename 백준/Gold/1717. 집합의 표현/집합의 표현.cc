#include <iostream>
using namespace std;

int n, m, parent[1000001];

int find(int x)
{
	if(parent[x] == x)
	{
		return x;
	}
	return parent[x] = find(parent[x]);
}

void Union(int x, int y)
{
	x = find(x);
	y = find(y);

	if(x == y)
	{
		return;
	}

	if(x < y)
	{
		parent[y] = x;
	}

	else
	{
		parent[x] = y;
	}
}

bool isUnion(int y, int x)
{
	x = find(x);
	y = find(y);

	return y == x;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	int a, b, c;
	for(int i = 0; i <= n; i++)
	{
		parent[i] = i;
	}
	for(int i = 0; i < m; i++)
	{
		cin >> c >> a >> b;
		if(c == 0)
		{
			Union(a, b);
		}

		else
		{
			if(isUnion(a, b))
			{
				cout << "YES\n";
			}
			else
			{
				cout << "NO\n";
			}
		}
	}
}
