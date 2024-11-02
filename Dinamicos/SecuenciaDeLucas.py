def lucas_tabulacion(n):
    if n == 0:
        return 2
    if n == 1:
        return 1

    # Guarda los resultados en una tabla para su uso
    lucas_table = [0] * (n + 1)
    lucas_table[0] = 2
    lucas_table[1] = 1

    for i in range(2, n + 1):
        lucas_table[i] = lucas_table[i - 1] + lucas_table[i - 2]

    return lucas_table[n]
# -----------------------------------------------------------------------------
# Guarda valores calculados en memoria
memo = {}

def lucas_memoization(n):
    if n == 0:
        return 2
    if n == 1:
        return 1

    # Verifica si el valor ya está en el diccionario (memorizado)
    if n in memo:
        return memo[n]

    # Calcula y guarda el resultado en el diccionario
    result = lucas_memoization(n - 1) + lucas_memoization(n - 2)
    memo[n] = result

    return result

n = 10
print(f"Lucas({n}) = {lucas_memoization(n)}")
print(f"Lucas({n}) = {lucas_tabulacion(n)}")
