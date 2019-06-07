__author__ = 'harshul'

import timeit

popzero = timeit.Timer("x[2]",
                       "from __main__ import x")
popend = timeit.Timer("x.pop()",
                      "from __main__ import x")

x = list(range(200000))
print(popzero.timeit(number=1000))

print(popend.timeit(number=1000))