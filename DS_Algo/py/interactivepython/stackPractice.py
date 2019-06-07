__author__ = 'harshul'

from interactivepython.basic.stack import Stack

#balanced parentheses problem
def parChecker(symbolString):
    s = Stack()
    balanced = True
    index = 0
    while index < len(symbolString) and balanced:
        symbol = symbolString[index]
        if symbol in "([{":
            s.push(symbol)
        else:
            if s.is_empty():
                balanced = False
            else:
                top = s.pop()
                if not matches(top,symbol):
                       balanced = False
        index = index + 1
    if balanced and s.is_empty():
        return True
    else:
        return False

def matches(open,close):
    opens = "([{"
    closers = ")]}"
    return opens.index(open) == closers.index(close)


print(parChecker('{{([][])}()}'))
print(parChecker('[{()]'))



#Write a function revstring(mystr) that uses a stack to reverse the characters in a string.
def reverse(s):
    st = Stack()
    for i in s:
        st.push(i)
    r = ''
    for i in range(st.size()):
        r = r+st.pop()
    return r



