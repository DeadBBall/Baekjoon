#include <stdio.h>
int main()
{
    int tmp, ans = 0;
    for(int i = 0; i < 5; i++)
    {
        scanf("%d", &tmp);
        ans += tmp;
    }
    printf("%d", ans);
}