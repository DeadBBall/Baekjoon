#include <stdio.h>
int main()
{
  int n[10000000];
  int m;
  scanf("%d", &m);
  for(int i = 0; i < m; i++)
    scanf("%d", &n[i]);
  for(int i = 1; i < m; i++)
  {
    int c = i;
    do
    {
      int root = (c - 1) / 2;
      if(n[root] < n[c])
      {
        int tmp = n[root];
        n[root] = n[c];
        n[c] = tmp;
      }
      c = root;
    } while (c != 0);
  }
  for(int i = m - 1; i >= 0; i--)
  {
    int tmp = n[0];
    n[0] = n[i];
    n[i] = tmp;
    int root = 0;
    int c = 1;
    do
    {
      c = 2 * root + 1;
      if(n[c] < n[c + 1] && c < i - 1)
        c++;
      if(n[root] < n[c] && c < i)
      {
       int tmp = n[root];
       n[root] = n[c];
       n[c] = tmp;
      }
      root = c;
    } while(c < i);
  }
  for(int i = 0; i < m; i++)
    printf("%d\n", n[i]);
}