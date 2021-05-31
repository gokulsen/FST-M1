list = []
num = int(input('How many numbers: '))
for n in range(num):
    numbers = int(input('Enter number '))
    list.append(numbers)
print(list)

if (list[0]==list[-1]):
    print("Ture")
else:
    print("False")