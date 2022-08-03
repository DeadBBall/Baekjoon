#include <stdio.h>
int main()
{
    int a[31] = {0};
    for(int i = 0; i < 28; i++)
    {
        int n;
        scanf("%d", &n);
        a[n] = 1;
    }
    for(int i = 1; i < 31; i++)
    {
        if (!a[i])
            printf("%d\n", i);
    }
}