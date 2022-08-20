#include <stdio.h>

int main()
{
	int a[20000001] = {0};
	int n, tmp, m;
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
	{
		scanf("%d", &tmp);
		a[tmp+10000000]++;
	}
	scanf("%d", &m);
	for(int i = 0; i < m; i++)
	{
		scanf("%d", &tmp);
		if (a[tmp+10000000])
			printf("1 ");
		else
			printf("0 ");
	}
}