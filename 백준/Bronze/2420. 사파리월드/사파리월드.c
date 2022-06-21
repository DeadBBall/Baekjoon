#include <stdio.h>
int main()
{
  long long n, m, ans;
  scanf("%lld %lld", &n, &m);
  if(n > m)
    printf("%lld", n - m);
  else
    printf("%lld", m - n);
}