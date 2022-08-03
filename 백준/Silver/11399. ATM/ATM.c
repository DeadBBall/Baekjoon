#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)    // 오름차순 비교 함수 구현
{
	return *(int *)a - *(int *)b;
}

int main()
{
	int n, ans = 0, tmp = 0, a[1001] = {0};
	scanf("%d", &n);
	for(int i = 0; i < n; i++)
		scanf("%d", &a[i]);
	qsort(a, n, sizeof(int),  compare);

	for(int i = 0; i < n; i++)
	{
		tmp += a[i];
		ans += tmp;
	}
	printf("%d", ans);
}