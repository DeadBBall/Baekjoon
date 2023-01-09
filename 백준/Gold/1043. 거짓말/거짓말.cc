#include <iostream>
#include <vector>
using namespace std;

int n, m, truth;
vector<int> truthInParty[51];
bool truePeople[51];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> truth;
	for(int i = 0; i < truth; i++)
	{
		int tmp;
		cin >> tmp;
		truePeople[tmp] = 1;
	}
	for(int i = 0; i < m; i++)
	{
		int	num;
		cin >> num;
		int flag = 0;
		for(int j = 0; j < num; j++)
		{
			int person;
			cin >> person;
			truthInParty[i].push_back(person);
			if(truePeople[person] == 1)
				flag = 1;
		}
		if(flag == 1)
		{
			for(int j = 0; j < truthInParty[i].size(); j++)
				truePeople[truthInParty[i][j]] = 1;
		}
	}
	for(int k = 0; k < m; k++)
	{
		for(int i = 0; i < m; i++)
		{
			int flag = 0;
			for(int j = 0; j < truthInParty[i].size(); j++)
			{
				if(truePeople[truthInParty[i][j]] == 1)
					flag = 1;
			}
			if(flag == 1)
			{
				for(int j = 0; j < truthInParty[i].size(); j++)
					truePeople[truthInParty[i][j]] = 1;
			}
		}
	}
	int party = 0;
	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < truthInParty[i].size(); j++)
		{
			if(truePeople[truthInParty[i][j]] == 1)
			{
				party++;
				break;
			}
		}
	}
	cout << m - party;
}