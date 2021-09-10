class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        counters = Counter(s)    
        countert = Counter(t)
        
        return counters == countert
