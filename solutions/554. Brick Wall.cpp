class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        unordered_map<int,int>m;
        
        for(int i=0;i<wall.size();i++)
        {
            int add=0;
            for(int j=0;j<wall[i].size()-1;j++)
            {
                add+=wall[i][j];
                m[add]++;
            }
        }
        
        int maxspace=0;
        for(auto i:m)
        {
            if(maxspace<i.second)
            {
                maxspace=i.second;
            }
        }
        return wall.size()-maxspace;
        
    }
};
