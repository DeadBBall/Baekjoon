#include <stdio.h>
int main()
{
  int l, p, h1, h2, h3, h4, h5;
  scanf("%d %d\n", &l, &p);
  scanf("%d %d %d %d %d", &h1, &h2, &h3, &h4, &h5);
  printf("%d %d %d %d %d", h1 - l * p, h2 - l * p, h3 - l * p, h4 - l * p, h5 - l * p);
}