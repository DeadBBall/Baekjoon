#include <iostream>
#include <stack>
using namespace std;
typedef pair<int, int> pii;

int n;
stack<pii> s;
int ans[500001];
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for(int i = 1; i <= n; i++)
	{
		int num;
		cin >> num;
		while(!s.empty())
		{
			pii now = s.top();
			if(now.first >= num)
			{
				ans[i] = now.second;
				break;
			}
			s.pop();
		}
		s.push({num, i});
	}
	for(int i = 1; i <= n; i++)
	{
		cout << ans[i] << " ";
	}
}