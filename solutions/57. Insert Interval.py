class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = [newInterval.copy()]
        for i in intervals:
            if i[1] < ans[-1][0]:
                ans.insert(len(ans) - 1, i)
            elif i[0] > ans[-1][1]:
                ans.append(i)
            else:
                ans[-1][1] = max(ans[-1][1], i[1])
                ans[-1][0] = min(ans[-1][0], i[0])
        return ans
