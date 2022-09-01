#include <stdio.h>
#include <string.h>

char d[1000001];
int main()
{
	int n, m, ans = 0;
	scanf("%d%d%s", &n, &m, d);
	int d_idx = 0;
	while (d[d_idx] && strlen(&d[d_idx]) >= n * 2 + 1)
	{
		int len = 0;
		if (d[d_idx] == 'O')
			d_idx++;
		else
		{
			while (d[d_idx + 1] == 'O' && d[d_idx + 2] == 'I')
			{
				len++;
				if (len == n)
				{
					ans++;
					len--;
				}
				d_idx += 2;
			}
			d_idx++;
		}
	}
	printf("%d", ans);
}