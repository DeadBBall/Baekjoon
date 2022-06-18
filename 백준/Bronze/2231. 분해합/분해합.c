#include <stdio.h>
int cal(int n)
{
  return(n + n % 10 + n / 10 % 10 + n / 100 % 10 + n / 1000 % 10 + n / 10000 % 10 + n / 100000 % 10 + n / 1000000);
}

int main()
{
  int n;
  scanf("%d", &n);
  int i = 1;
  while(i <= n)
  {
    if(n == cal(i))
    {
      printf("%d", i);
      return(0);
    }
    else
      i++;
  }
  printf("0");
}