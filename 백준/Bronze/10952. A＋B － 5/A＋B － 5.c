#include <stdio.h>
int main()
{
    for(int i = 0; ; i++)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        if(!a)
            break;
        printf("%d\n", a + b);
    }
}