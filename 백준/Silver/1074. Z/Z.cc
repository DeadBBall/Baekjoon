#include <iostream>
using namespace std;

int n, y_obj, x_obj, ans = 0;

void solve(int inputY, int inputX, int size)
{
	if(inputY == y_obj && inputX == x_obj)
	{
		cout << ans;
		return;
	}
	if(y_obj < inputY + size && y_obj >= inputY &&
			x_obj < inputX + size && x_obj >= inputX)
	{
		solve(inputY, inputX, size / 2);
		solve(inputY, inputX + size / 2, size / 2);
		solve(inputY + size / 2, inputX, size / 2);
		solve(inputY + size / 2, inputX + size / 2, size / 2);
	}
	else
		ans += size * size;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n >> y_obj >> x_obj;
	solve(0, 0, 1 << n);
}