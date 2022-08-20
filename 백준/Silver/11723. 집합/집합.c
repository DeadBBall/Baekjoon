#include <stdio.h>

int make_2(int n)
{
	int num = 0b1;
	for (int i = 20; i >= n; i--)
		num *= 2;
	return (num);
}

int main()
{
	int m, n = 0;
	scanf("%d", &m);
	for(int i = 0; i < m; i++)
	{
		char c[10];
		int num, tmp;
		scanf("%s", c);
		if (c[0] == 'a' && c[1] == 'd')
		{
			scanf("%d", &num);
			tmp = make_2(num);
			if ((tmp & n) != tmp)
				n += tmp;
		}
		else if (c[0] == 'c')
		{
			scanf("%d", &num);
			tmp = make_2(num);
			if ((tmp & n) != tmp)
				printf("0\n");
			else
				printf("1\n");
		}
		else if (c[0] == 'r')
		{
			scanf("%d", &num);
			tmp = make_2(num);
			if ((tmp & n) == tmp)
				n -= tmp;
		}
		else if (c[0] == 't')
		{
			scanf("%d", &num);
			tmp = make_2(num);
			if ((tmp & n) != tmp)
				n += tmp;
			else
				n -= tmp;
		}
		else if (c[0] == 'a' && c[1] == 'l')
			n = 0b11111111111111111111;
		else
			n = 0;
	}
}