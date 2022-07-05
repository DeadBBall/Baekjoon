#include <stdio.h>
int main()
{
    char c[101];
    scanf("%s", &c);
    int i = 0;
    while(c[i])
    {
        if(65 <= c[i] && c[i] <= 90)
            c[i] += 32;
        else
            c[i] -= 32;
      i++;
    }
    printf("%s", c);
}