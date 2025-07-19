class DynamicArray:

    def __init__(self, capacity: int):
        self.dArray = [-1] * capacity
        self.capacity = capacity
        self.last = 0

    def get(self, i: int) -> int:
        return self.dArray[i]

    def set(self, i: int, n: int) -> None:
        self.dArray[i] = n

    def pushback(self, n: int) -> None:
        # is full
        if self.capacity == self.last:
            self.resize()
        self.dArray[self.last] = n
        self.last += 1

    def popback(self) -> int:
        # 여기 놓쳤음!!!
        if self.last > 0:
            self.last -= 1
        return self.dArray[self.last]

    def resize(self) -> None:
        self.capacity *= 2
        newArray = [-1] * self.capacity
        for i in range(len(self.dArray)):
            newArray[i] = self.dArray[i]
        self.dArray = newArray

    def getSize(self) -> int:
        return self.last

    def getCapacity(self) -> int:
        return self.capacity
