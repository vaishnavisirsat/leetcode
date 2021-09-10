class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if(p.size() > s.size()){
            return vector<int>();
        }
        map<char,int> org;
        for(int i = 97;i<=122;i++){
            org[i]=0;
        }
        for(auto it : p){
            org[it]++;
        }
        int n1 = s.size();
        int n2 = p.size();
        map<char,int> to;
        for(int i = 97;i<=122;i++){
            to[i]=0;
        }
        vector<int> v;
        for(int i=0;i<n1;i++){
            if(i>=n2){
                to[s[i - n2]]--;
            }
            to[s[i]]++;
            if( to == org){
                v.push_back(i + 1 - n2);
            }
        }
        return v;
    }
};
