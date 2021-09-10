class Solution(object):
    def commonChars(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        if len(words) == 0:
            return
        
        ref = words[0] # reference word to compare to rest of list
        ret = []
            
        for char in ref:
            valid = True
            for i in range(1, len(words)):
                # break if word does not contain this char
                if not char in words[i]:
                    valid = False
                    break
                else:
                    # replace first occurrence of char with blank (allow duplicates)
                    words[i] = words[i].replace(char, "", 1)
            if valid:
                ret.append(char)
                    
        return ret
