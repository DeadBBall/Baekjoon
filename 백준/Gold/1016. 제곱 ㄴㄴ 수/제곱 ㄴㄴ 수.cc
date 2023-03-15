#include <iostream>
using namespace std;
typedef long long ll;

ll minNum, maxNum;
int ans;
bool visit[1000001];

void input()
{
	cin >> minNum >> maxNum;
}

void checkNum()
{
	for(ll i = 2; i * i <= maxNum; i++)
	{
		ll num = minNum / (i * i);
		if(minNum % (i * i) != 0)
		{
			num++;
		}
		while(num * i * i <= maxNum)
		{
			visit[num * i * i - minNum] = true;
			num++;
		}
	}

	for(int i = 0; i <= maxNum - minNum; i++)
	{
		if(!visit[i])
		{
			ans++;
		}
	}
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    input();
    checkNum();
    cout << ans;
}
