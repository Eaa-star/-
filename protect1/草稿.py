import sys

mod = 998244353
M = mod - 1

m_val = 31596
table = {}
current = 1
for j in range(m_val):
    if current not in table:
        table[current] = j
    current = (current * 2) % mod

g = pow(2, M - m_val, mod)

def discrete_log(a):
    if a == 1:
        return 0
    current = a
    for i in range(m_val + 1):
        if current in table:
            j = table[current]
            x = i * m_val + j
            if x < M:
                return x
        current = (current * g) % mod
    return -1

def main():
    data = sys.stdin.read().split()
    if not data:
        return
    t = int(data[0])
    index = 1
    results = []
    for _ in range(t):
        a = int(data[index])
        b = int(data[index+1])
        index += 2
        if a == 0 or b == 0:
            results.append("-1")
            continue
        u0 = discrete_log(a)
        v0 = discrete_log(b)
        if u0 == -1 or v0 == -1:
            results.append("-1")
            continue
        
        best_n = None
        for k1 in range(0, 3):
            for k2 in range(0, 3):
                u = u0 + k1 * M
                v = v0 + k2 * M
                if (2 * u - v) % 3 != 0 or (2 * v - u) % 3 != 0:
                    continue
                x = (2 * u - v) // 3
                y = (2 * v - u) // 3
                if x >= 0 and y >= 0:
                    n_val = (u + v) // 3
                    if best_n is None or n_val < best_n:
                        best_n = n_val
        if best_n is None:
            results.append("-1")
        else:
            results.append(str(best_n))
    print("\n".join(results))

if __name__ == "__main__":
    main()