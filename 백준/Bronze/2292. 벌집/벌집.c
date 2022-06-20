#include <stdio.h>
int main()
{
  int n, i;
  scanf("%d", &n);
  for(i = 0;;i++)
  {
    if(n <= 1 + 3 * i * (i + 1))
    {
      printf("%d", i + 1);
      return (0);
    }
  }
}