#include <stdio.h>

int main()
{
	int t, n, m, a, b;
	scanf("%d", &t);
	for(int i = 0; i < t; i++)
	{
		scanf("%d%d", &n, &m);
		for(int j = 0; j < m; j++)
			scanf("%d%d", &a, &b);
		printf("%d\n", n - 1);
	}
}