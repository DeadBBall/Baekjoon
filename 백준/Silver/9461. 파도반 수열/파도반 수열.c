#include <stdio.h>

int main()
{
	long t, p[101] = {1, 1, 1, 1};
	scanf("%ld", &t);
	for(int j = 0; j < t; j++)
	{
		long tmp;
		scanf("%ld", &tmp);
		for(long i = 4; i <= tmp; i++)
			p[i] = p[i -2] + p[i - 3];
		printf("%ld\n", p[tmp]);
	}
}
