class Solution:

    def encode(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""

        encoded = ""
        for s in strs:
            length = len(s)
            encoded += str(length) + "#" + s

        return encoded

    def decode(self, s: str) -> List[str]:
        if len(s) == 0:
            return []

        result = []
        i = 0

        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1

            length = int(s[i:j])
            i = j + 1
            result.append(s[i:i + length])
            i += length

        return result
