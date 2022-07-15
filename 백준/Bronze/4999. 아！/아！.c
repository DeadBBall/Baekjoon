#include <stdio.h>
int main()
{
  char a[1001], b[1001];
  scanf("%s\n%s", &a, &b);
  int i = 0;
  while(1)
  {
    if(!b[i])
    {
      printf("go");
      return (0);
    }
    else if(!a[i])
    {
      printf("no");
      return (0);
    }
    i++;
  }
}