
# Developed: Paulo Henrique Araujo Munhoz  data: 2020/04/07

array1 = input('Enter first word: ')
array2 = input('Enter second word: ')
array1 = array1.strip()
array2 = array2.strip()


def checktypos(first, second):
    if first == second: return "False - No changes"

    t = 0
    k = 0
    w = 0
    diff = 0
    ldiff = 0
    aux2 = second
    aux1 = first

    if len(first) == len(second):
        j = 0
        for x in first:
            if x != second[j]:
                diff = diff + 1
            j = j + 1
        if diff <= 1: return "True"
    if len(first) > len(second):
        ldiff = len(first) - len(second)
        while ldiff > 0:
            aux2 += " "
            ldiff = ldiff - 1
        for y in first:
            if y != aux2[t]:
                aux2 = aux2[0:t] + y + aux2[t:(len(aux2) - 1)]
                diff = diff + 1
            t = t + 1
    else:
        ldiff = len(second) - len(first)
        while ldiff > 0:
            aux1 += " "
            ldiff = ldiff - 1
        for w in second:
            if w != aux1[k]:
                aux1 = aux1[0:k] + w + aux1[k:(len(aux1) - 1)]
                diff = diff + 1
            k = k + 1

    return diff == 1


print(checktypos(array1, array2))
