#include <stdio.h>
int main()
{
	int n;
	int a[1001];
	scanf("%d", &n);
	a[1] = 1;
	a[2] = 2;
	for(int i = 3; i <= n; i++)
		a[i] = (a[i - 1] + a[i - 2]) % 10007;
	printf("%d", a[n]);
}