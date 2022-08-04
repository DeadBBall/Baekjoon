#include <stdio.h>
int main()
{
	int n, a[301] = {0}, b[301] = {0};
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		scanf("%d", &a[i]);
	b[1] = a[1];
	b[2] = a[1] + a[2];
	for (int i = 3; i <= n; i++)
		b[i] = b[i - 2] + a[i] > b[i - 3] + a[i -1] + a[i] ? b[i - 2] + a[i] : b[i - 3] + a[i -1] + a[i];
	printf("%d", b[n]);
}