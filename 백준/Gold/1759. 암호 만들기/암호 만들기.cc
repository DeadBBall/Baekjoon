#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int l, c;
string alp, ans;

int countVowel()
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
	if(ans.size() == l)
	{
		int vowel = countVowel();
		int consonant = l - vowel;
		if(1 <= vowel && 2 <= consonant)
			cout << ans << "\n";
		return;
	}
	for(int i = cnt; i < c; i++)
	{
		ans.push_back(alp[i]);
		makeCode(i + 1);
		ans.pop_back();
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
	sort(alp.begin(), alp.end());
	makeCode(0);
}