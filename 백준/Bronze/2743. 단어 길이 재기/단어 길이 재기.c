#include <stdio.h>
int main()
{
    char c[101];
    scanf("%s", c);
    int i = 0;
    while(c[i])
        i++;
    printf("%d", i);
}