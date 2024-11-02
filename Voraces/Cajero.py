# Disponibilidad de billetes y sus denominaciones (es importante el orden)
billetes = [
    {"valor": 100000, "disponibles": 50, "usados": 0},
    {"valor": 50000, "disponibles": 100, "usados": 0},
    {"valor": 20000, "disponibles": 200, "usados": 0},
    {"valor": 10000, "disponibles": 300, "usados": 0},
]

def entregar_dinero(cantidad_solicitada):
    # Verificamos que la cantidad solicitada sea múltiplo de 10,000
    if cantidad_solicitada % 10000 != 0:
        return "La cantidad solicitada debe ser múltiplo de 10,000."

    # Crear un registro temporal de billetes usados en esta transacción
    billetes_utilizados = []
    cantidad_restante = cantidad_solicitada  # Copia del valor solicitado para ir reduciendo

    # Algoritmo voraz para seleccionar billetes (comienza con el de mayor valor)
    for billete in billetes:
        if cantidad_restante <= 0:
            break
        # Obtiene el valor del billete actual
        valor_billete = billete["valor"]
        max_billetes = cantidad_restante // valor_billete
        # Asegurarse de que no se usen más billetes de los que hay disponibles
        # Usar el valor minimo entre los billetes que se usa y los billetes disponibles
        # Ejemplo (1, 50) escogerá 1, pero si es (8, 6) escogerá 6
        billetes_usados = min(max_billetes, billete["disponibles"])
        # Agregar al registro temporal de usados en esta transacción
        billetes_utilizados.append({"valor": valor_billete, "usados": billetes_usados})
        # Actualizamos la cantidad solicitada y los billetes utilizados
        cantidad_restante -= billetes_usados * valor_billete
        billete["disponibles"] -= billetes_usados
        billete["usados"] += billetes_usados

    # Verificar si se cumplió la cantidad solicitada
    if cantidad_restante > 0:
        # Revertir cambios si no se pudo completar la transacción
        for usado in billetes_utilizados:
            valor = usado["valor"]
            revertir_billete = next(b for b in billetes if b["valor"] == valor)
            revertir_billete["disponibles"] += usado["usados"]
            revertir_billete["usados"] -= usado["usados"]
        return "No hay suficiente cantidad de billetes para entregar el dinero solicitado."

        # Preparar el resultado con los billetes utilizados en la solicitud exitosa
    resultado = {f"{billete['valor']} COP": billete["usados"] for billete in billetes}
    return resultado

cantidad_solicitada1 = 380000
#cantidad_solicitada2 = 540000
#cantidad_solicitada3 = 580000
#cantidad_solicitada4 = 3880000

resultado1 = entregar_dinero(cantidad_solicitada1)
#resultado2 = entregar_dinero(cantidad_solicitada2)
#resultado3 = entregar_dinero(cantidad_solicitada3)
#resultado4 = entregar_dinero(cantidad_solicitada4)
print(resultado1)
#print(resultado2)
#print(resultado3)
#print(resultado4)
