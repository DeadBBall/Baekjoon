#include <iostream>
#include <map>
#include <string>

using namespace std;
string st[1000001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	map<string, int> ma;
	int n, m;

	string s;
	cin >> n >> m;
	for(int i = 1; i <= n; i++)
	{
		cin >> s;
		st[i] = s;
		ma.insert(pair<string, int>(s, i));
	}
	for(int i = 0; i < m; i++)
	{
		cin >> s;
		if(isdigit(s[0]) == true)
			cout << st[stoi(s)] << "\n";
		else
		{
			auto it = ma.find(s);
			cout << it->second << "\n";
		}
	}
}