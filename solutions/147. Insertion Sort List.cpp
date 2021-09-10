/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        ListNode* anshead=head;
        ListNode* temp=head->next;
        anshead->next=NULL;
        while(temp!=NULL)
        {
            ListNode* curr_node=temp;
            temp=temp->next;
            curr_node->next=NULL;
            ListNode* c=anshead; ListNode* prev=NULL;
            while(c!=NULL && c->val<curr_node->val)
            {
                prev=c;
                c=c->next;
            }
            if(!c)
                prev->next=curr_node;
            else
            {
                if(!prev)
                {
                    curr_node->next=anshead;
                    anshead=curr_node;
                } 
                else
                {
                    ListNode* tt=prev->next;
                    prev->next=curr_node;
                    curr_node->next=tt;
                }
            }
        }
        return anshead;
