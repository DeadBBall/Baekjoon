#include <iostream>
#include <set>

using namespace std;

int main()
{
	set<string> s;
	set<string>::iterator it;
	set<string>::reverse_iterator rit;

	int n;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		string name;
		string enle;

		cin >> name;
		cin >> enle;
		if (enle == "leave")
			s.erase(name);
		else
			s.insert(name);
	}
	for(rit = s.rbegin(); rit != s.rend(); rit++)
		cout << *rit << "\n";
}