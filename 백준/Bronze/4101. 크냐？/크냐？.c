#include <stdio.h>
int main()
{
  int a, b;
  for(int i = 0; ;i++)
  {
    scanf("%d%d", &a, &b);
    if(a == 0 && b == 0)
      break;
    else if(a > b)
      printf("Yes\n");
    else
      printf("No\n");
  }
}