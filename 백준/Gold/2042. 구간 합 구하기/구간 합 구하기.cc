#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

vector <ll> arr;
int n, m, k;
vector <ll> fenwick;

void update(int idx, ll value)
{
	while(idx < (int)fenwick.size())
	{
		fenwick[idx] += value;
		idx += (idx & -idx);
	}
}

ll sum(int idx)
{
	ll sum = 0;
	while(idx > 0)
	{
		sum += fenwick[idx];
		idx -=(idx & -idx);
	}
	return sum;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> k;
	fenwick.resize(n + 1);
	arr.resize(n + 1);
	for(int i = 1; i <= n; i++)
	{
		cin >> arr[i];
		update(i, arr[i]);
	}
	for(int i = 0; i < m + k; i++)
	{
		int a, b;
		ll c;
		cin >> a >> b >> c;
		if(a == 1)
		{
			ll diff = c - arr[b];
			arr[b] = c;
			update(b, diff);
		}
		else
			cout << sum(c) - sum(b - 1) << "\n";
	}
}