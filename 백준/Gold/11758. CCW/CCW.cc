#include <iostream>
using namespace std;
typedef pair<int, int> pii;

pii p1, p2, p3;

void inputProb()
{
	cin >> p1.second >> p1.first >> p2.second >> p2.first >> p3.second >> p3.first;
}

void ccw()
{
	int ans = 0;
	if((p2.second - p1.second)*(p3.first - p1.first) - (p3.second - p1.second)*(p2.first - p1.first) < 0)
		ans = -1;
	else if((p2.second - p1.second)*(p3.first - p1.first) - (p3.second - p1.second)*(p2.first - p1.first) > 0)
		ans = 1;
	cout << ans;
}
void solve()
{
	inputProb();
	ccw();
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);
	solve();
}