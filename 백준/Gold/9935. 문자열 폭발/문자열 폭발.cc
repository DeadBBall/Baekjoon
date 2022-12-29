#include <iostream>
#include <string>
using namespace std;

string origin, bomb, answer;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> origin >> bomb;
	for(int i = 0; origin[i] != 0; i++)
	{
		if(origin[i] == bomb[bomb.size() - 1])
		{
			int j = answer.size() - 1;
			int k;
			for(k = bomb.size() - 2; k >= 0; k--)
			{
				if(answer[j--] != bomb[k])
					break;
			}
			if(k == -1)
			{
				for(int i = 0; i < bomb.size() - 1; i++)
					answer.pop_back();
			}
			else
				answer.push_back(origin[i]);
		}
		else
			answer.push_back(origin[i]);
	}
	if(answer.length() != 0)
		cout << answer;
	else
		cout << "FRULA";
}