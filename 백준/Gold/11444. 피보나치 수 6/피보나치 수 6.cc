#include <iostream>
#include <map>
using namespace std;
typedef long long ll;
#define mod 1000000007

map<ll, ll> dic;

ll fibo(ll n)
{
	if (n < 0)
		cout << "n<0\n";
	if (n == 0)
		return 0;
	else if (n == 1)
		return 1;
	else if (dic[n] > 0)
		return dic[n];
	else if (n % 2 == 0)
	{
		ll m = n/2;
		ll tmp = fibo(m-1);
		ll tmp2 = fibo(m);
		dic[n] = (2 * tmp + tmp2) * tmp2;
		dic[n] %= mod;
		return dic[n];
	}
	else
	{
		ll m = (n + 1) / 2;
		ll tmp = fibo(m);
		ll tmp2 = fibo(m - 1);
		dic[n] = tmp * tmp + tmp2 * tmp2;
		dic[n] %= mod;
		return dic[n];
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	ll n;
	cin >> n;
	cout << fibo(n);
}