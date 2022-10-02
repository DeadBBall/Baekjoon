#include <iostream>

using namespace std;

int main()
{
	int n;
	cin >> n;
	char c[n][80];
	for(int i = 0; i < n; i++)
	{
		cin >> c[i];
		int idx = 0;
		int tmp = 0;
		int ans = 0;
		while(c[i][idx])
		{
			if(c[i][idx++] == 'O')
			{
				tmp++;
				ans += tmp;
			}
			else
				tmp = 0;
		}
		cout << ans << endl;
	}
}