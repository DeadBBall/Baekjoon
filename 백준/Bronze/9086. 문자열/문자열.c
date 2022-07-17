#include <stdio.h>
int main()
{
  int n;
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
  {
    char tmp[1001];
    scanf("%s\n", &tmp);
    printf("%c", tmp[0]);
    for(int j = 0; ;j++)
    {
      if(tmp[j] == 0)
      {
        printf("%c\n", tmp[j - 1]);
        break;
      } 
    }
  }
}