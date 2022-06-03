#include <stdio.h>
#include <string.h>

int cmp(char c[], char d[])
{
  if(strlen(c) < strlen(d))
    return 1;
  else if(strlen(c) > strlen(d))
    return 0;
  if(strcmp(c, d) > 0)
    return 0;
  else if(strcmp(c, d) < 0)
    return 1;
  return 0;
}

int main()
{
  int n;
  char d[100];
  scanf("%d", &n);
  char c[50000][100];
  for(int i = 0; i < n; i++)
  {
    int j = 0;
    scanf("%s", d);
    while(j < i)
    {
      if (!strcmp(c[j], d))
      { 
        i--;
        n--;
        break;
      }
      j++;
    }
    if (j == i)
      strcpy(c[i],d);
  }
  for(int i = 1; i < n; i++)
  {
    int e = i;
    do
    {
      char d[100];
      int root = (e - 1) / 2;
      if(cmp(c[root], c[e]))
      {
        strcpy(d, c[root]);
        strcpy(c[root], c[e]);
        strcpy(c[e], d);
      }
      e = root;
    } while (e != 0);
  }
  for(int i = n - 1; i >= 0; i--)
  {
    char d[100];
    strcpy(d, c[0]);
    strcpy(c[0], c[i]);
    strcpy(c[i], d);
    int root = 0;
    int e = 1;
    do
    {
      char d[100];
      e = 2 * root + 1;
      if(cmp(c[e], c[e + 1]) && e < i - 1)
        e++;
      if(cmp(c[root], c[e]) && e < i)
      {
       char d[100];
       strcpy(d, c[root]);
       strcpy(c[root], c[e]);
       strcpy(c[e], d);
      }
      root = e;
    } while(e < i);
  }
  for(int i = 0; i < n; i++)
    printf("%s\n", c[i]);
}