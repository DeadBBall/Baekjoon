#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int aMax, bMax, cMax;
bool visit[201][201][201];
vector<int> v;

void input()
{
    cin >> aMax >> bMax >> cMax;
    visit[0][0][cMax] = true;
}

void moveWater(int a, int b, int c)
{
    if(a == 0)
    {
        v.push_back(c);
    }
    if(a != 0)
    {
         if(a > bMax - b)
        {
            int newA = a - (bMax - b);
            int newB = bMax;
            int newC = c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = 0;
            int newB = b + a;
            int newC = c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        if(a > cMax - c)
        {
            int newA = a - (cMax - c);
            int newB = b;
            int newC = cMax;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = 0;
            int newB = b;
            int newC = a + c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
    }
    if(b != 0)
    {
        if(b > aMax - a)
        {
            int newA = aMax;
            int newB = b - (aMax - a);
            int newC = c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = a + b;
            int newB = 0;
            int newC = c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        if(b > cMax - c)
        {
            int newA = a;
            int newB = b - (cMax - c);
            int newC = cMax;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = a;
            int newB = 0;
            int newC = b + c;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
    }
    if(c != 0)
    {
        if(c > aMax - a)
        {
            int newA = aMax;
            int newB = b;
            int newC = c - (aMax - a);
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = a + c;
            int newB = b;
            int newC = 0;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        if(c > bMax - b)
        {
            int newA = a;
            int newB = bMax;
            int newC = c - (bMax - b);
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
        else
        {
            int newA = a;
            int newB = b + c;
            int newC = 0;
            if(!visit[newA][newB][newC])
            {
                visit[newA][newB][newC] = true;
                moveWater(newA, newB, newC);
            }
        }
    }
}

int main()
{
    input();
    moveWater(0, 0, cMax);
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
}