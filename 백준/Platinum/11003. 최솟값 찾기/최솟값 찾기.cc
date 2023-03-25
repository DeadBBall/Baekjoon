#include <iostream>
#include <deque>
using namespace std;
typedef pair<int, int> pii;

int n, l, num;
deque<pii> dq;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> l;
	cin >> num;
	dq.push_front({num, 0});
	cout << dq.front().first;
	for(int i = 1; i < n; i++)
	{
		cin >> num;
		if(dq.front().second < i - l + 1)
		{
			dq.pop_front();
		}
		while (!dq.empty() && dq.back().first > num)
		{
			dq.pop_back();
		}
    dq.push_back({num, i});
		cout << " " << dq.front().first;
	}
}
