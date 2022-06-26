#include <stdio.h>
#include <string.h>

int main()
{
  int n;
  int stack[10001];
  scanf("%d", &n);
  int num = -1;
  char tmp[10001][7];
  int tmpt[10001];
  for(int i = 0; i < n; i++)
  {
    scanf("%s", &tmp[i]);
    if(strcmp("push", tmp[i]) == 0)
      scanf("%d", &tmpt[i]);
  }
  for(int i = 0; i < n; i++)
  {
    if(strcmp("push", tmp[i]) == 0)
    {
      num++;
      stack[num] = tmpt[i];
    }
    else if(strcmp("pop", tmp[i]) == 0)
    {
      if(num == -1)
        printf("-1\n");
      else
      {
        printf("%d\n", stack[num]);
        num--;
      }
    }
    else if(strcmp("size", tmp[i]) == 0)
      printf("%d\n", num + 1);
    else if(strcmp("empty", tmp[i]) == 0)
    {
      if(num == -1)
        printf("1\n");
      else
        printf("0\n");
    }
    else
    {
      if(num == -1)
        printf("-1\n");
      else
        printf("%d\n", stack[num]);
    }
  }
}