#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, string> pis;

int calD(int input)
{
	int output = input * 2;
	if(output > 9999)
		output %= 10000;
	return output;
}

int calS(int input)
{
	int output = input - 1;
	if(output == -1)
		output = 9999;
	return output;
}

int calL(int input)
{
	return input % 1000 * 10 + input / 1000;
}

int calR(int input)
{
	return input % 10 * 1000 + input / 10;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	while(t--)
	{
		int a, b;
		bool visit[10000] = {0};
		cin >> a >> b;
		// cout << calL(a) << " " << calR(a) << "\n";
		queue<pis> q;
		q.push({a, ""});
		while(!q.empty())
		{
			pis now = q.front();
			q.pop();
			for(int i = 0; i < 4; i++)
			{
				if(i == 0)
				{
					int tmp = calD(now.first);
					if(!visit[tmp])
					{
						q.push({tmp, now.second + "D"});
						visit[tmp] = true;
					}
				}
				else if(i == 1)
				{
					int tmp = calS(now.first);
					if(!visit[tmp])
					{
					q.push({tmp, now.second + "S"});
						visit[tmp] = true;
					}
				}
				else if(i == 2)
				{
					int tmp = calL(now.first);
					if(!visit[tmp])
					{
					q.push({tmp, now.second + "L"});
						visit[tmp] = true;
					}
				}
				else
				{
					int tmp = calR(now.first);
					if(!visit[tmp])
					{
					q.push({tmp, now.second + "R"});
						visit[tmp] = true;
					}
				}
			}
			if(now.first == b)
			{
				cout << now.second << "\n";
				break;
			}
		}
	}
}