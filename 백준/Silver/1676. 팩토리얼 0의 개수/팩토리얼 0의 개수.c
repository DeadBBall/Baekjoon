#include <stdio.h>
int main()
{
  int n;
  int n2 = 0;
  int n5 = 0;
  scanf("%d", &n);
  for(int i = 1; i <= n; i++)
  {
    int m = i;
    while(m > 1)
    {
      if(m % 2 == 0)
      {
        m /= 2;
        n2++;
      }
      if(m % 5 == 0)
      {
        m /= 5;
        n5++;
      }
      if(m % 2 != 0 && m % 5 != 0)
        break;
    }
  }
  printf("%d", n2 > n5 ? n5 : n2);
}