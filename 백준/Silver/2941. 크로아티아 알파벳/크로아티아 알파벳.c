#include <stdio.h>

int main()
{
  char c[105];
  scanf("%s", c);
  int ans = 0;
  int i = 0;
  while(c[i])
  {
    if(c[i] == 'c' && c[i+1] == '=')
    {  
      ans++;
      i+=2;
    }
    else if(c[i] == 'c' && c[i+1] == '-')
    {
      ans++;
      i+=2;
    }
    else if(c[i] == 'd' && c[i+1] == '-')
    {
      ans++;
      i+=2;
    }
    else if(c[i] == 'd' && c[i+1] == 'z' && c[i+2] == '=')
    {
      ans++;
      i+=3;
    }
    else if(c[i] == 'l' && c[i+1] == 'j')
    {
      ans++;
      i+=2;
    }
    else if(c[i] == 'n' && c[i+1] == 'j')
    {
      ans++;
      i+=2;
    }
    else if(c[i] == 's' && c[i+1] =='=')
    {
      ans++;
      i+=2;
    }
    else if(c[i] == 'z' && c[i+1] == '=')
    {
      ans++;
      i+=2;
    }
    else
    {
      ans++;
      i++;
    }
  }
  printf("%d", ans);
}