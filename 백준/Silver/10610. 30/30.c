#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char c[100001];

int compare(const void *a, const void *b)
{
  return *(char *)b-*(char *)a;
}

int main()
{
	scanf("%s", c);
	int n = 0, m = strlen(c);
	for (int i = 0; i < m; i++)
		n += c[i] - 48;
	qsort(c, m, 1, compare);
	if (n % 3 || c[m - 1] != '0')
		printf("-1");
	else
		printf("%s", c);
}