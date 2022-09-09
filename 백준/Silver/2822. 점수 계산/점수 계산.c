#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
	return *(int *)a - *(int *)b;
}

int main()
{
	int n[8], ans = 0;
	int rank[5] = {0};
	for (int i = 0; i < 8; i++)
		scanf("%d", &n[i]);
	for(int i = 0; i < 5; i++)
	{
		int max = 0;
		for(int j = 0; j < 8; j++)
			if (max < n[j])
			{
				max = n[j];
				rank[i] = j;
			}
		ans += n[rank[i]];
		n[rank[i]] = -1;
	}
	printf("%d\n", ans);
	qsort(rank, 5, sizeof(int), compare);
	for(int i = 0; i < 5; i++)
		printf("%d ", rank[i] + 1);
}