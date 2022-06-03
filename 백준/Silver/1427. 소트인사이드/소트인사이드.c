#include <stdio.h>

int main()
{
  char n[20];
  scanf("%s", &n);
  int i;
  for(i = 1; n[i] != 0; i++)
  {
    int c = i;
    do
    {
      int root = (c - 1) / 2;
      if(n[root] < n[c])
      {
        char tmp = n[root];
        n[root] = n[c];
        n[c] = tmp;
      }
      c = root;
    } while (c != 0);
  }
  for(int j = i - 1; j >= 0; j--)
  {
    char tmp = n[0];
    n[0] = n[j];
    n[j] = tmp;
    int root = 0;
    int c = 1;
    do
    {
      c = 2 * root + 1;
      if(n[c] < n[c + 1] && c < j - 1)
        c++;
      if(n[root] < n[c] && c < j)
      {
       char tmp = n[root];
       n[root] = n[c];
       n[c] = tmp;
      }
      root = c;
    } while(c < j);
  }
  for(i = i - 1; i >= 0; i--)
    printf("%c", n[i]);
}