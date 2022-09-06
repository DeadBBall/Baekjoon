#include <stdio.h>
#include <stdlib.h>

int a[5000000];
int compare(const void *a, const void *b)
{
  return *(int *)a - *(int *)b;
}

int main()
{
	int n, k;
	scanf("%d%d", &n, &k);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	qsort(a, n, sizeof(int), compare);
	printf("%d", a[k - 1]);
}
