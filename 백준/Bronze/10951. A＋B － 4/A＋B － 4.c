#include <stdio.h>
int main()
{
    for(int i = 0; ; i++)
    {
        int a = 0;
        int b = 0;
        scanf("%d%d", &a, &b);
        if (!a && !b)
            break ;
        printf("%d\n", a + b);
    }
}