#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int sec = 0;
	for(int i = 0; i < 4; i++)
	{
		int tmp;
		cin >> tmp;
		sec += tmp;
	}
	cout << sec / 60 << "\n" << sec % 60;
}