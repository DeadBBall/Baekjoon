#include <stdio.h>
#include <math.h>

int a[1001] = {0};
int main()
{
	int n, k, ans = 0;
	scanf("%d%d", &n, &k);
	for(int j = 2; j <= n; j++)
	{
		for(int s = j; s <= n; s += j)
		{
			if(!a[s])
			{
				a[s] = 1;
				ans++;
			}
			if (ans == k)
			{
				printf("%d", s);
				return (0);
			}
		}
	}
}