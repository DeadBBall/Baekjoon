#include <iostream>
#include <set>

using namespace std;

int main()
{
	set<string> s;
	set<string>::iterator it;
	set<string> s2;
	int n, m;
	cin >> n;
	cin >> m;
	for(int i = 0; i < n; i++)
	{
		string name;

		cin >> name;
		s.insert(name);
	}
	for(int i = 0; i < m; i++)
	{
		string name;

		cin >> name;
		it = s.find(name);
		if(it != s.end())
			s2.insert(name);
	}
	cout << s2.size() << "\n";
	for(it = s2.begin(); it != s2.end(); it++)
		cout << *it <<"\n";
}