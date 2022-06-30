#include <stdio.h>

void check(char c[])
{
  int j[50] = {0};
  int k = -1;
  for(int i = 0; c[i] != 0 ; i++)
  {
    if(c[i] == '(')
    {
      k++;
      j[k] = 1;
    }
    if(c[i] == ')')
    {
      j[k] = 0;
      k--;
    }
    if(k <= -2)
      break;
  }
  if(k == -1)
    printf("YES\n");
  else
    printf("NO\n");
}

int main()
{
  int n;
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
  {
    char c[51];
    scanf("%s", &c);
    check(c);
  }
}