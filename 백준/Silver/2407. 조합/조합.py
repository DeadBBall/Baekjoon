n, m = input().split()
n = int(n)
m = int(m)
ans = 1
tmp = 1
while m > 0:
  ans *= n
  tmp *= m
  if ans % tmp == 0:
    ans //= tmp
    tmp = 1
  n -= 1
  m -= 1
print(ans)