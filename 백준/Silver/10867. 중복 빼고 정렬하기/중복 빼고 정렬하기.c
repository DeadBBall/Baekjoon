#include <stdio.h>
#include <stdlib.h>

int arr[100000];

int compare(const void *a, const void *b)
{
	return *(int *)a - *(int *)b;
}

int main()
{
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	qsort(arr, n, sizeof(int), compare);
	for (int i = 0; i < n; i++)
	{
		if (!i)
			printf("%d ", arr[i]);
		else if (arr[i - 1] != arr[i])
			printf("%d ", arr[i]);
	}
}