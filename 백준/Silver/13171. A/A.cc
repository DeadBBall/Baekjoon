#include <iostream>
using namespace std;
typedef unsigned long long ull;
#define mod 1000000007

ull solve(ull a, ull b)
{
	if(b == 0)
		return 1;
	ull n = solve(a, b / 2);
	ull temp = (n * n) % mod;
	if (b % 2 == 0)
		return temp;
	else
		return (temp * a) % mod;

}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	ull a, b;
	cin >> a >> b;
	cout << solve(a % mod, b);
}