#include <stdio.h>

int main()
{
	for(int i = 0; ;i++)
	{
		int ans = 0;
		char c[256];
		gets(c);
		if (c[0] == '#')
			break;
		int j = 0;
		while (c[j])
		{
			if (c[j] == 'a' || c[j] == 'A' || c[j] == 'e' || c[j] == 'E' || c[j] == 'i' || c[j] == 'I' || c[j] == 'o' || c[j] == 'O' || c[j] == 'u' || c[j] == 'U')
				ans++;
			j++;
		}
		printf("%d\n", ans);
	}
}