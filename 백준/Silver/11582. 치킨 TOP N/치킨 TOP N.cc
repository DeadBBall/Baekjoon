#include <iostream>
#include <algorithm>
using namespace std;

int chicken[1048576], n, k;

void div_con(int num)
{
	if(num < k)
		return;
	for(int i = 0; i < n; i += n / num)
		sort(&chicken[i], &chicken[i] + n / num);
	div_con(num / 2);
}

int main()
{
	ios::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> chicken[i];
	cin >> k;
	div_con(n / 2);
	for(int i = 0; i < n; i++)
		cout << chicken[i] << " ";
}