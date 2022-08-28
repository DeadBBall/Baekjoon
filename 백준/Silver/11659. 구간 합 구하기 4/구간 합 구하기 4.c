#include <stdio.h>
int a[100001] = {0}, s[100001] = {0};
int main()
{
	int n, m;
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &a[i]);
		if (i == 1)
			s[1] = a[1];
		else
			s[i] = a[i] + s[i - 1];
	}
	for (int i = 0; i < m; i++)
	{
		int start, end;
		scanf("%d%d", &start, &end);
		printf("%d\n", s[end] - s[start - 1]);
	}
}
