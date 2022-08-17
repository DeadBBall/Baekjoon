#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}

int r_compare(const void *a, const void *b)
{
    return *(int *)b - *(int *)a;
}

int main()
{
	int n, a[51] = {0}, b[51] = {0}, ans = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	for (int i = 0; i < n; i++)
		scanf("%d", &b[i]);
	qsort(a, n, sizeof(int), compare);
	qsort(b, n, sizeof(int), r_compare);
	for (int i = 0; i < n; i++)
		ans += (a[i] * b[i]);
	printf("%d", ans);
}
