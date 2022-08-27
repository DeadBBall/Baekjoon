#include <stdio.h>

int main()
{
	int n, a[1001];
	a[1] = 1;
	a[2] = 3;
	scanf("%d", &n);
	for(int i = 3; i <= n; i++)
		a[i] = (a[i -1] + 2 * a[i - 2]) % 10007;
	printf("%d", a[n]);
}