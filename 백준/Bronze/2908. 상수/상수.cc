#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int a, b;
	cin >> a >> b;
	int rA, rB;
	rA = a / 100 + a / 10 % 10 * 10 + a % 10 * 100;
	rB = b / 100 + b / 10 % 10 * 10 + b % 10 * 100;
	cout << (rA > rB ? rA : rB);
}