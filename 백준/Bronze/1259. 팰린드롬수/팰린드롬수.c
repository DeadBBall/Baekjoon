#include <stdio.h>
#include <string.h>

char* rev(char c[6], char d[6])
{
  int i = 0;
  while(c[i])
    i++;
  for(int j = 0; i != -1; j++)
    d[j] = c[--i];
  return (d);
}
int main()
{
  char c[1000][6];
  int i;
  for(i = 0; ; i++)
  {
    scanf("%s", &c[i]);
    if(c[i][0] == '0')
      break;
  }
  for(int j = 0; j < i; j++)
  {
    char tmp[6];
    if(strcmp(c[j], rev(c[j], tmp)))
      printf("no\n");
    else
      printf("yes\n");
  }
}