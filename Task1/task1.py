
# Developed: Paulo Henrique Araujo Munhoz  data: 2020/04/06

array = input('Enter the Array: ')
n = input('Number: ')
array = array.strip()
x = len(array)
sentence = []
j = 0

for i in array:
    if array[j] == ' ':
        sentence.append("&32")
    else:
        sentence.append(array[j])
    j = j + 1

new = "".join(sentence)

print('New Sentence: %s' % new)
