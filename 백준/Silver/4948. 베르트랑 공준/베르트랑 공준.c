#include <stdio.h>
#include <math.h>

int a[246913] = {1, 1, 0, };
int main()
{
	for (int i = 0; ;i++)
	{
		int n, ans = 0;
		scanf("%d", &n);
		if (!n)
			return (0);
		for(int j = 2; j <= sqrt(2 * n); j++)
		{
			if(!a[j])
				for(int s = j * j; s <= 2 * n; s += j)
					a[s] = 1;
		}
		for(int j = n + 1; j <= n * 2; j++)
			if(!a[j])
				ans++;
		printf("%d\n", ans);
	}
}