__author__ = 'harshul'

class Queue:
    def __init__(self):
        self.items+ []

    def isEmpty(self):
        return self.items == []

    def enque(self, item):
        self.items.insert(0, item)

    def deque(self):
        return self.items.pop

    def size(self):
        return len(self.items)