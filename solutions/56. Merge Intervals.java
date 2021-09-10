                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);
​
                for (int[] child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }
​
    // gets the connected components of the interval overlap graph.
    private void buildComponents(int[][] intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;
​
        for (int[] interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }
​
    public int[][] merge(int[][] intervals) {
        buildGraph(intervals);
        buildComponents(intervals);
​
        // for each component, merge all intervals into one interval.
        List<int[]> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }
​
        return merged.toArray(new int[merged.size()][]);
    }
}
