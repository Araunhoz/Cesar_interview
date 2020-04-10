
# Developed: Paulo Henrique Araujo Munhoz  data: 2020/04/07

array1 = input('Enter first word: ')
array2 = input('Enter second word: ')
array1 = array1.strip()
array2 = array2.strip()

def verify (array1,array2):
  if (len(array1) == len(array2)):
    if (array1[0] == array2[0]):
      length = len(array2)
      j = 0
      diff = 0
      for x in array2:
        first = array1[j]
        if x != first:
          diff = diff + 1
        j= j+1
      if length > 3:
        if diff < ((length/3.0)*2):
          return "True"
      else:
        if diff > 0:
          return "True"
  return "False"

print (verify (array1,array2))