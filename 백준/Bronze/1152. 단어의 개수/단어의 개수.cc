#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s;
	getline(cin, s);
	int idx = 0, ans = 1;
	if(s.empty())
	{
		cout << "0";
		return 0;
	}
	while(idx < s.length())
	{
		if(s[idx] == ' ')
			ans++;
		idx++;
	}
	if (s[0] == ' ')
		ans--;
	if (s[s.length() - 1] == ' ')
		ans--;
	cout << ans;
}