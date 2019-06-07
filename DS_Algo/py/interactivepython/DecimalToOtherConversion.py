__author__ = 'harshul'

from interactivepython.basic.stack import Stack

#base conversion
def baseConverter(decNumber,base):
    digits = "0123456789ABCDEF"

    remstack = Stack()

    while decNumber > 0:
        rem = decNumber % base
        remstack.push(rem)
        decNumber = decNumber // base

    newString = ""
    while not remstack.is_empty():
        newString = newString + digits[remstack.pop()]

    return newString

#print(baseConverter(25,2))
#print(baseConverter(25,16))

#decimal to binary conversion
def divideBy2(decNumber):
    remstack = Stack()

    while decNumber > 0:
        rem = decNumber % 2
        remstack.push(rem)
        decNumber = decNumber // 2

    binString = ""
    while not remstack.is_empty():
        binString = binString + str(remstack.pop())

    return binString

print(divideBy2(42))