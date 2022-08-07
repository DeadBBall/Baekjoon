#include <stdio.h>
int a[100001], b[100001];

int main()
{
	int n;
	scanf("%d", &n);
	for(int i = 1; i <= n; i++)
		scanf("%d", &a[i]);
	b[n] = a[n];
	int max = a[n];
	for(int i = n - 1; i > 0; i--)
	{
		b[i] = b[i + 1] + a[i] > a[i] ? b[i + 1] + a[i] : a[i];
		if (max < b[i])
			max = b[i];
	}
	printf("%d", max);
}