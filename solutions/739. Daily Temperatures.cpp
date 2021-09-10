class Solution
{
public:
  vector<int> dailyTemperatures(vector<int> &temperatures)
  {
    int n = (int)temperatures.size();
    vector<int> ans(n, 0);
    std::stack<std::pair<int, int>> myStack; // [value, index]
    for (int i = 0; i < n; ++i)
    {
      while (!myStack.empty() && temperatures[i] > myStack.top().first)
      {
        ans[myStack.top().second] = i - myStack.top().second;
        myStack.pop();
      }
      myStack.push(std::make_pair(temperatures[i], i));
    }
    return ans;
  }
};
