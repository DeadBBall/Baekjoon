#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int l, c;
string alp, ans;
bool visit[15];

int includeVowel()
{
	int vowel = 0;
	for(int i = 0; i < l; i++)
	{
		if(ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'o' || ans[i] == 'i' || ans[i] == 'u')
			vowel++;
	}
	return vowel;
}

void makeCode(int cnt)
{
	if(cnt == l)
	{
		int vowel = includeVowel();
		int consonant = l - vowel;
		if(1 <= vowel && 2 <= consonant)
			cout << ans << "\n";
		return;
	}
	for(int i = 0; i < c; i++)
	{
		if((cnt == 0 || ans[cnt - 1] < alp[i]) && !visit[i])
		{
			visit[i] = 1;
			ans[cnt] = alp[i];
			makeCode(cnt + 1);
			visit[i] = 0;
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> l >> c;
	for(int i = 0; i < c; i++)
	{
		string input;
		cin >> input;
		alp.push_back(input[0]);
	}
	for(int i = 0; i < l; i++)
		ans.push_back('a');
	sort(alp.begin(), alp.end());
	makeCode(0);
}