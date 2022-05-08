#include <stdio.h>

long long ncr(long long k, long long j)
{
    long long i = 1;
    long long a = k-j;
    if(a < j)
        a = k - (j=k-j);
    while(k != a)
    {
        i *= k;
        k--;
    }
    while(j != 1)
    {
        i /= j;
        j--;
    }
    return ((long long)i);
}

int main()
{
    int n;
    int j;
    int k;
    int l;
    scanf("%d", &n);
    long long arr[n];
    l = 0;
    for(int i=0; i<n; i++)
    {
       
        scanf("%d", &j);
        scanf("%d", &k);
        if(j != k)
            arr[l] = ncr(k, j);
        else
            arr[l] = 1;
        l++;
    }
    l = 0;
    while(l < n)
    {
        printf("%d\n", (int)arr[l]);
        l++;
    }
}