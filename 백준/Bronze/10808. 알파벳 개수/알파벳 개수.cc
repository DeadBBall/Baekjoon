#include <iostream>

using namespace std;

int main()
{
	string s;
	cin >> s;
	int idx = -1, alp[26] = {0};
	while(s[++idx])
		alp[s[idx] - 'a']++;
	for(int i = 0; i < 26; i++)
		cout << alp[i] << " ";
}