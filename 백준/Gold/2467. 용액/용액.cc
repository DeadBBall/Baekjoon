#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int n, arr[100000], key, low, high, ans = INT_MAX;

void input()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
}

bool binarySearch(int start, int end)
{
	while (start <= end)
	{
		int mid = (start + end) / 2;
		if (arr[mid] + key == 0)
		{
			if (arr[mid] < key)
			{
				low = arr[mid];
				high = key;
			}
			else
			{
				low = key;
				high = arr[mid];
			}
			return true;
		}
		if (arr[mid] + key > 0)
		{
			if (abs(arr[mid] + key) < ans)
			{
				if (arr[mid] < key)
				{
					low = arr[mid];
					high = key;
				}

				else
				{
					low = key;
					high = arr[mid];
				}
				ans = abs(arr[mid] + key);
			}
			end = mid - 1;
		}
		else
		{
			if (abs(arr[mid] + key) < ans)
			{
				if (arr[mid] < key)
				{
					low = arr[mid];
					high = key;
				}

				else
				{
					low = key;
					high = arr[mid];
				}
				ans = abs(arr[mid] + key);
			}
			start = mid + 1;
		}
	}
	return false;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	for (int i = 0; i < n; i++)
	{
		key = arr[i];
		if (binarySearch(i + 1, n - 1))
		{
			break;
		}
	}
	cout << low << " " << high;
}