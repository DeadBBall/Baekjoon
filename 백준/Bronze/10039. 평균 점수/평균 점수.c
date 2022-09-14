#include <stdio.h>

int main()
{
	int stu[5], ans = 0;
	for(int i = 0; i < 5; i++)
	{
		scanf("%d", &stu[i]);
		if (stu[i] < 40)
			stu[i] = 40;
		ans += stu[i];
	}
	printf("%d", ans / 5);
}