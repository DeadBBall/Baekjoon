#include <stdio.h>
#include <stdlib.h>

int a[2000000];

int compare(const void *a, const void *b)
{
	return (*(int *)a - *(int *)b);
}
int main()
{
	int n, m;
	scanf("%d%d", &n, &m);
	for(int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	for(int i = n; i < n + m; i++)
		scanf("%d", &a[i]);
	qsort(a, n+m, sizeof(int), compare);
	for(int i = 0; i < n + m; i++)
		printf("%d ", a[i]);
}