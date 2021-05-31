#import functools

#tempTuple = tuple([eval(x) for x in input("enter the values: ").split(',')])

#intTuple = functools.reduce(lambda sub, ele: sub * 10 + ele, tempTuple)
#print(intTuple)

intTuple = (5,6,10,15,16,25)

for num in intTuple:
    if (num % 5 == 0):
        print(num)