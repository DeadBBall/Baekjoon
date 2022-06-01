#include <stdio.h>
int main()
{
  long long n;
  long long i;
  scanf("%d", &n);
  for(i = 1; n > 0; i++)
    n -= i;
  if(n < 0)
    i-=1;
  printf("%d", i - 1);
}