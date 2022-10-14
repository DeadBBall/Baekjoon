#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s;
	int idx = 0, n = 0, flag = 0;
	cin >> s;
	while(s[idx])
	{
		if(flag == 0)
			n += stoi(&s[idx]);
		else
			n -= stoi(&s[idx]);
		while('0' <= s[idx] && s[idx] <= '9')
			idx++;
		if(s[idx] == '-' && flag == 0)
			flag = 1;
		if(s[idx] != 0)
			idx++;
	}
	cout << n;
}