#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ten_x(int n)
{
	int i = 1;
	while (--n)
		i *= 10;
	return (i);
}

int main()
{
	char c[10];
	scanf("%s", c);
	int n, len, ans = 0;
	n = atoi(c);
	len = strlen(c);
	ans += (n - ten_x(len) + 1) * len;
	for(int i = 1; i < len; i++)
		ans += (ten_x(i + 1) - ten_x(i)) * i;
	printf("%d", ans);
}
