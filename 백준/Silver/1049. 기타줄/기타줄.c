#include <stdio.h>

int main()
{
	int n, m, tmp[2], min[2], ans = 0;
	scanf("%d%d", &n, &m);
	for(int i = 0; i < m; i++)
	{
		scanf("%d%d", &tmp[0], &tmp[1]);
		if (!i)
		{
			min[0] = tmp[0];
			min[1] = tmp[1];
		}
		if(min[0] > tmp[0])
			min[0] = tmp[0];
		if(min[1] > tmp[1])
			min[1] = tmp[1];
	}
	ans = min[0] < 6 * min[1] ? n / 6 * min[0] : min[1] * n;
	n %= 6;
	if (n && min[0] < 6 * min[1])
		ans += min[0] < n % 6 * min[1] ? min[0] : n % 6 * min[1];
	printf("%d", ans);
}