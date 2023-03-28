#include <iostream>
#include <vector>
#include <string>
#include <map>
using namespace std;

int t, n, f1n, f2n, cnt;
string f1, f2;
map<string, int> m;
vector<int> v;
vector<int> setRank;

int find(int x)
{
	if (v[x] == x)
	{
		return x;
	}
	return v[x] = find(v[x]);
}

void Union(int x, int y)
{
	x = find(x);
	y = find(y);
	if (x == y)
	{
		return;
	}
	if (setRank[x] > setRank[y])
	{
		setRank[x] += setRank[y];
		setRank[y] = setRank[x];
	}
	else
	{
		setRank[y] += setRank[x];
		setRank[x] = setRank[y];
	}
	if (x > y)
	{
		v[x] = y;
	}
	else
	{
		v[y] = x;
	}
}

bool isUnion(int x, int y)
{
	x = find(x);
	y = find(y);
	return x == y;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> t;
	for (int tc = 0; tc < t; tc++)
	{
		m.clear();
		v.clear();
		setRank.clear();
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> f1 >> f2;
			if (m.find(f1) == m.end())
			{
				m.insert({f1, m.size()});
				v.push_back(v.size());
				setRank.push_back(1);
				f1n = v.size() - 1;
			}
			else
			{
				f1n = (*m.find(f1)).second;
			}
			if (m.find(f2) == m.end())
			{
				m.insert({ f2, m.size() });
				v.push_back(v.size());
				setRank.push_back(1);
				f2n = v.size() - 1;
			}
			else
			{
				f2n = (*m.find(f2)).second;
			}
			Union(f1n, f2n);
			cout << setRank[find(f1n)] << "\n";
		}
	}
}