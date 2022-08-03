#include <stdio.h>
int main()
{
    int n[6];
    for(int i = 0; i < 6; i++)
        scanf("%d", &n[i]);
    printf("%d %d %d %d %d %d", 1 - n[0], 1 - n[1], 2 - n[2], 2 - n[3], 2 - n[4], 8 - n[5]);
}