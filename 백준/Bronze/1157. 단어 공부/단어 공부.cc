#include <iostream>
#include <string>

using namespace std;

int main()
{
	int alp[26] = {0}, ans[2] = {0};
	string s;
	cin >> s;
	int idx = 0;
	while(idx < s.length())
	{
		if('A' <= s[idx] && s[idx] <= 'Z')
			alp[s[idx] - 'A']++;
		else if('a' <= s[idx] && s[idx] <= 'z')
			alp[s[idx] - 'a']++;
		idx++;
	}
	idx = 0;
	int tmp = 0;
	while(idx < 26)
	{
		if(alp[idx] > ans[0])
		{
			ans[0] = alp[idx];
			ans[1] = idx;
			tmp = 0;
		}
		else if(alp[idx] == ans[0] && alp[idx] != 0)
			tmp++;
		idx++;
	}
	if(tmp == 0)
		cout << char('A' + ans[1]);
	else
		cout << '?';
}