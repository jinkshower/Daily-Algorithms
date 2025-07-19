class Pair:

    def __init__(self, key, value):
        self.key = key
        self.value = value


class HashTable:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.hashMap = [None] * self.capacity

    def insert(self, key: int, value: int) -> None:
        hashed = self.hashing(key)

        while self.hashMap[hashed] != None:
            if self.hashMap[hashed].key == key:
                self.hashMap[hashed].value = value
                return
            hashed += 1
            hashed = hashed % self.capacity

        self.hashMap[hashed] = Pair(key, value)
        self.size += 1

        # resize
        # if half full
        if self.size >= self.capacity // 2:
            self.resize()
        print(self.hashMap)
        return

    def get(self, key: int) -> int:
        hashed = self.hashing(key)

        # deal collision - open addressing
        while self.hashMap[hashed] != None:
            if self.hashMap[hashed].key == key:
                return self.hashMap[hashed].value
            hashed += 1
            hashed = hashed % self.capacity

        return -1

    def remove(self, key: int) -> bool:
        hashed = self.hashing(key)

        # deal collision
        while self.hashMap[hashed] != None:
            if self.hashMap[hashed].key == key:
                self.hashMap[hashed] = None
                self.size -= 1
                return True
            hashed += 1
            hashed = hashed % self.capacity

        return False

    def getSize(self) -> int:
        return self.size

    def getCapacity(self) -> int:
        return self.capacity

    def resize(self) -> None:
        self.capacity *= 2
        newMap = [None, None] * self.capacity
        self.size = 0

        oldMap = self.hashMap
        self.hashMap = newMap

        for entry in oldMap:
            if entry:
                key, value = entry.key, entry.value
                self.insert(key, value)

    def hashing(self, key: int) -> int:
        return key % self.capacity
