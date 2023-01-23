#include <iostream>
using namespace std;
#define INF 1000000000

int n, sign[4], arr[10], maxAns = - INF, minAns = INF;

void calculate(int cnt, int sum)
{
	if(cnt == n)
	{
		maxAns = max(sum, maxAns);
		minAns = min(sum, minAns);
		return;
	}

	for(int i = 0; i < 4; i++)
	{
		if(sign[i] == 0)
			continue;
		int nSum = 0;
		if(i == 0)
				nSum = sum + arr[cnt];
		else if(i == 1)
				nSum = sum - arr[cnt];
		else if(i == 2)
				nSum = sum * arr[cnt];
		else
				nSum = sum / arr[cnt];
		sign[i]--;
		calculate(cnt + 1, nSum);
		sign[i]++;
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	for(int i = 0; i < 4; i++)
		cin >> sign[i];
	calculate(1, arr[0]);
	cout << maxAns << "\n" << minAns;
}