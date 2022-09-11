#include <stdio.h>
#include <string.h>

int alp[26] = {0};
char s[10][9];

int tenx(int a)
{
	int n = 1;
	while(--a)
		n *= 10;
	return n;
}

int main()
{
	int n, ans = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%s", s[i]);
		for (int j = 0; s[i][j]; j++)
			alp[s[i][j] - 'A'] += tenx(strlen(s[i]) - j);
	}
	for(int j = 0; j < 10; j++)
	{
		int max[2] = {0};
		for(int i = 0; i < 26; i++)
		{
			if (alp[i] > max[0])
			{
				max[0] = alp[i];
				max[1] = i;
			}
		}
		if(alp[max[1]] != -1)
			ans += alp[max[1]] * (9 - j);
		alp[max[1]] = -1;
	}
	printf("%d", ans);
}