#include <stdio.h>
int main()
{
    int n, ans = 1;
    scanf("%d", &n);
    for (int i = 2; i <= n; i++)
        ans *= i;
    printf("%d", ans);
}
