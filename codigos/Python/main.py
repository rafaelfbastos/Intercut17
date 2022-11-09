def calcular_raiz(numero):
    raiz = 1;
    
    while raiz*raiz<numero:
        raiz+=1
    
    if raiz == numero:
        return raiz
    
    limite_superior = raiz
    limite_inferior = raiz-1
    raiz = (limite_inferior+limite_superior)/2
    erro = abs(raiz*raiz-numero)

    while erro>1E-10:
        
        if raiz*raiz>numero:
            limite_superior = raiz
        else:
            limite_inferior = raiz
        raiz = (limite_inferior+limite_superior)/2
        erro = abs(raiz*raiz-numero)

    return raiz

def calcular_divisores(numero):
    denominadores = []

    for i in range(1,numero+1):
        if numero%i==0:
           denominadores.append(i)
    return denominadores

def mdc_comparando(numero1,numero2):
    mdc = 1
    divisores1 = calcular_divisores(abs(numero1))
    divisores2 = calcular_divisores(abs(numero2))

    for divisor1 in divisores1:
        for divisor2 in divisores2:
            if divisor1==divisor2:
                mdc = divisor1
    
    return mdc


def mdc(numero1, numero2):
    dividendo = abs(numero1) if abs(numero1)>abs(numero2) else abs(numero2)
    divisor = abs(numero2) if abs(numero1)>abs(numero2) else abs(numero1)

    while dividendo%divisor!=0:
        resto = dividendo%divisor
        dividendo = divisor
        divisor = resto

    return divisor


print(mdc(85,45))
print(mdc_comparando(85,45))