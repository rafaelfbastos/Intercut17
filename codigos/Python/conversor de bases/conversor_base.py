
map_caracteres = {
    "0":0,
    "1":1,
    "2":2,
    "3":3,
    "4":4,
    "5":5,
    "6":6,
    "7":7,
    "8":8,
    "9":9,
    "a":10,
    "b":11,
    "c":12,
    "d":13,
    "e":14,
    "f":15,
}
lista_bases = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "hex", "hexadecimal"]

def validar_base(numero):
    
    numero = numero.__str__()

    if numero in lista_bases:
        return True
    else: 
        return False

def validar_base_numero(numero,base):
    
    if base=="hex" or base=="hexadecimal":
        base = 16
    else:
        base = int(base)

    lita_caracteres_validos = [*map_caracteres.keys()][:base]
    validador = []
    numero = numero.__str__()
    numero = numero.lower()
    for c in numero:
        validador.append(True if c in lita_caracteres_validos else False )

    return all(validador)

def converter_base10(numero, base_atual):
    
    numero = str(numero)
    numero = numero.lower()
    base_atual = str(base_atual)
    base_atual = base_atual.lower()

    lista_algarismos = [map_caracteres[algarismo]  for algarismo in numero]
    lista_algarismos.reverse()
    
    if base_atual=="hex" or base_atual=="hexadecimal":
        base_atual = 16
    else:
        base_atual = int(base_atual)
    
    resposta = 0


    for i in range(len(lista_algarismos)):
        resposta = resposta + lista_algarismos[i]*base_atual**i


    return resposta

def converter_base(numero, base_atual, base_desejada):
    numero_base10 = converter_base10(numero,base_atual)
    lista_algarismos =[]

    base_desejada = str(base_desejada)
    base_desejada = base_desejada.lower()

    if base_desejada=="hex" or base_desejada=="hexadecimal":
        base_desejada = 16
    else:
        base_desejada = int(base_desejada)

    while(numero_base10>=base_desejada):
        lista_algarismos.append(numero_base10%base_desejada)
        numero_base10 = int(numero_base10/base_desejada)

    lista_algarismos.append(numero_base10)

    lista_algarismos.reverse()

    resposta=""

    for algarismo in lista_algarismos:
        resposta = resposta+str(algarismo)
    
    return resposta






