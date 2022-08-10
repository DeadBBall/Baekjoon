#include <stdio.h>
int main()
{
	int n, tmp, a[201] = {0};
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &tmp);
		a[tmp + 100]++;
	}
	scanf("%d", &n);
	printf("%d", a[n + 100]);
}