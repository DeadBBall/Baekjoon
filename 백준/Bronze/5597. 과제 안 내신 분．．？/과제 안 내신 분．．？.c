#include <stdio.h>
int main()
{
    int n[30] = {0};
    for(int i = 0; i < 28; i++)
    {
        int tmp;
        scanf("%d", &tmp);
        n[tmp - 1] = 1;
    }
    for(int i = 0; i < 30; i++)
    {
        if(!n[i])
            printf("%d\n", i + 1);
    }
}