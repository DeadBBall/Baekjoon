#include <stdio.h>

int main()
{
    int n;
    int i;
    
    n = 1;
    i = 1;

    while(n <= 10000)
    {
        while(i <= n)
        {
            if((i/10%10 + i + i%10 + i/100%10 + i/1000%10) == n)
                break ;
            i++;
        }
        if ((i/10%10 + i + i%10 + i/100%10 + i/1000%10) != n)
            printf("%d\n", n);
        n++;
        i = 1;
    }
}