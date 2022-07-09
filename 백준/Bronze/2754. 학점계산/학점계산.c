#include <stdio.h>
#include <string.h>
int main()
{
  char c[3];
  scanf("%s", c);
  if(!strcmp("A+", c))
    printf("4.3");
  else if(!strcmp("A0", c))
    printf("4.0");
  else if(!strcmp("A-", c))
    printf("3.7");
  else if(!strcmp("B+", c))
    printf("3.3");
  else if(!strcmp("B0", c))
    printf("3.0");
  else if(!strcmp("B-", c))
    printf("2.7");
  else if(!strcmp("C+", c))
    printf("2.3");
  else if(!strcmp("C0", c))
    printf("2.0");
  else if(!strcmp("C-", c))
    printf("1.7");
  else if(!strcmp("D+", c))
    printf("1.3");
  else if(!strcmp("D0", c))
    printf("1.0");
  else if(!strcmp("D-", c))
    printf("0.7");
  else
    printf("0.0");
}