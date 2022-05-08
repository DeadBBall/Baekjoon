#include <stdio.h>

int main()
{
    int n;
    int ans = 0;
    char c[100];
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        int arr[26] = {0};    
        int k = 0;
        scanf("%s", &c);
        while(c[k])
        {
            if(c[k] != c[k+1])
                arr[c[k]-97]++;
            k++;
        }
        int j;
        for(j = 0; j < 26; j++)
        {
            if(arr[j] > 1)
                break;
        }
        if (j == 26)
            ans++;
    }
    printf("%d", ans);
}