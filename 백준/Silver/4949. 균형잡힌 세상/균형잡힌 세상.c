#include <stdio.h>
int main()
{
	for(int i = 0; ; i++)
	{
		char c[101];
		int n_idx = -1;
		int n[100] = {0};
		gets(c);
		if(c[0] == '.')
			return (0);
		for (int j = 0; c[j]; j++)
		{
			if (c[j] == '[')
			{
				n_idx++;
				n[n_idx] = 1;
			}
			else if(c[j] == '(')
			{
				n_idx++;
				n[n_idx] = 2;
			}
			else if (c[j] == ']')
			{
				if(n[n_idx] == 1)
				{
					n[n_idx] = 0;
					n_idx--;

				}
				else
				{
					n_idx = 0;
					break;
				}
			}
			else if (c[j] == ')')
			{
				if(n[n_idx] == 2)
				{
					n[n_idx] = 0;
					n_idx--;
				}
				else
				{
					n_idx = 0;
					break;
				}
			}
		}
		if (n_idx == -1)
			printf("yes\n");
		else
			printf("no\n");
	}
}
