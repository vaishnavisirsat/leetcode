            else {
                curr = new Node;
                curr->key = key;
                curr->val = value;
                curr->next = NULL;
                curr->prev = prev;
                prev->next = curr;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int hash_code = key % maxn;
        Node* curr = hash_map[hash_code];
        
        while (curr!=NULL) {
            if (curr->key == key) return curr->val;
            curr = curr->next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int hash_code = key % maxn;
        Node* curr = hash_map[hash_code];
        
        while (curr!=NULL) {
            if (curr->key==key) {
                if (curr->prev==NULL && curr->next==NULL) {
                    delete curr;
                    hash_map[hash_code] = NULL;
                }
                else if (curr->prev==NULL) {
                  hash_map[hash_code] = curr->next;
                  hash_map[hash_code]->prev = NULL;
                  delete curr;
                }
                else if (curr->next==NULL) {
                  curr->prev->next = NULL;
                  delete curr;
                }
                else {
                  curr->prev->next = curr->next;
                  curr->next->prev = curr->prev;
                  
                    delete curr;
                }
                break;
            }
            curr = curr->next;
        }
    }
};
