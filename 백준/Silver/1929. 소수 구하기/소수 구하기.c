#include <stdio.h>
void ispn(int n)
{
  int i;
  for(i = 2; i * i <= n; i++)
  {
    if(n % i == 0)
      break;
  }
  if(i * i > n)
    printf("%d\n", n);
}

int main()
{
  int m, n;
  scanf("%d %d", &m, &n);
  if(m == 1)
    m++;
  while(m <= n)
  {
    ispn(m);
    m++;
  }
}