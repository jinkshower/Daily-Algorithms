class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        alpha = [0] * 26

        for c in s:
            ascii = ord(c) - 97
            alpha[ascii] += 1

        for c in t:
            ascii = ord(c) - 97
            alpha[ascii] -= 1

        for a in alpha:
            if a != 0:
                return False

        return True
