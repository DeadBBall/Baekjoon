#include <stdio.h>

void what_is_num(int i, int k)
{
    int ans = 0;
    while(i <= k)
    {   
        int n = 1;
        for(int m = i; 0 < m; n++)
        {
            m-=n;
            if(m <= 0)
                break;
        }
        ans += n;
        i++;
    }
    printf("%d", ans);
}

int main()
{
    int i, k;
    scanf("%d %d", &i, &k);
    what_is_num(i, k);
}