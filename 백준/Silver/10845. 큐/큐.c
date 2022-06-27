#include <stdio.h>
#include <string.h>

int main()
{
  int n;
  int queue[10001];
  scanf("%d", &n);
  int size = -1;
  char tmp[10001][7];
  int tmpt[10001];
  for(int i = 0; i < n; i++)
  {
    scanf("%s", &tmp[i]);
    if(!strcmp("push", tmp[i]))
      scanf("%d", &tmpt[i]);
  }
  for(int i = 0; i < n; i++)
  {
    if(!strcmp("push", tmp[i]))
    {
      size++;
      queue[size] = tmpt[i];
    }
    else if(!strcmp("pop", tmp[i]))
    {
      if(size == -1)
        printf("-1\n");
      else
      {
        printf("%d\n", queue[0]);
        size--;
        for (int j = 0; j < size + 1; j++)
          queue[j] = queue[j + 1];
      }
    }
    else if(!strcmp("size", tmp[i]))
      printf("%d\n", size + 1);
    else if(!strcmp("empty", tmp[i]))
    {
      if(size == -1)
        printf("1\n");
      else
        printf("0\n");
    }
    else if(!strcmp("front", tmp[i]))
    {
      if(size == -1)
        printf("-1\n");
      else
        printf("%d\n", queue[0]);
    }
    else
       {
      if(size == -1)
        printf("-1\n");
      else
        printf("%d\n", queue[size]);
    }
  }
}