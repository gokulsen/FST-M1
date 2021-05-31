#num = int(input("Enter a number: "))

def recursiveAdder(num):
  if num:
    return num + recursiveAdder(num-1)
  else:
    return 0

result = recursiveAdder(10)
print(result)