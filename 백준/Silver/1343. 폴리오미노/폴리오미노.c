#include <stdio.h>
int main()
{
  int i = 0;
  char c[55] = {0};
  scanf("%s", c);
  while(c[i] != 0)
  {
    if (c[i] == 'X' && c[i+1] == 'X')
      {
        if(c[i+2] != 'X')
        {
          c[i] = 'B';
          c[i+1] = 'B';
          i += 2;
        }
        else if(c[i+2] == 'X' && c[i+3] == 'X')
        {
          c[i] = 'A';
          c[i+1] = 'A';
          c[i+2] = 'A';
          c[i+3] = 'A';
          i += 4;
        }
        else
        {
          printf("-1");
          return (0);
        }
      }
    else if(c[i] == '.')
      i++;
    else
    {
      printf("-1");
      return (0);
    }
  }
  printf("%s", c);
}