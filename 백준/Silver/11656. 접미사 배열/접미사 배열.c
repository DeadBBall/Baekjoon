#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char a[1000][1001];

int compare(const void *b, const void *c)
{
	return strcmp((char *)b, (char *)c);
}

int main()
{
	char s[1001];
	scanf("%s", s);
	int i = 0;
	while(*(s + i))
	{
		strcpy(a[i], s + i);
		i++;
	}
	qsort(a, i, sizeof(a[0]), compare);
	for(int j = 0; j < i; j++)
		printf("%s\n", a[j]);
}
