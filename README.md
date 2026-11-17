# Data Structures, Algorithms & Competitive Programming (Java)

Consolidated archive of **461 Java implementations** spanning competitive programming rounds, classic algorithmic paradigms, and core data structure internals.

<p>
  <img src="https://img.shields.io/badge/Language-Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Implementations-461_Java_Solutions-0284C7?style=flat-square" alt="461 Solutions" />
  <img src="https://img.shields.io/badge/Focus-Graphs_%C2%B7_DP_%C2%B7_Trees_%C2%B7_CP-10B981?style=flat-square" alt="Topics" />
</p>

---

## Repository Breakdown (`DSAGame/src/com/dsagame/`)

| Package Namespace | Files | Coverage & Focus Areas |
| :--- | ---: | :--- |
| [`leetcode/`](./DSAGame/src/com/dsagame/leetcode) | **126** | Dynamic Programming (`29`), Graphs (`20`), Linked Lists (`13`), Trees (`12`), Stacks/Queues/Heaps, Biweekly Contests & Daily Challenges (`27`). |
| [`gfgselfpaced/`](./DSAGame/src/com/dsagame/gfgselfpaced) & [`gfgextras/`](./DSAGame/src/com/dsagame/gfgextras) | **110** | From-scratch implementations of Arrays, BSTs, Deques, Binary Heaps, Linked Lists, Stacks, Queues, and Trees. |
| [`pepcoding/`](./DSAGame/src/com/dsagame/pepcoding) | **70** | State-space Recursion & Backtracking, Tabulated Dynamic Programming, and Graph Connectivity/Traversal. |
| [`striver/`](./DSAGame/src/com/dsagame/striver) & [`sheet/`](./DSAGame/src/com/dsagame/sheet) | **70** | Striver A2Z DSA Sheet—Binary Search on Answer, Graph Shortest Paths, Tree Views/LCA, Sorting, and Recursion. |
| [`codeforces/`](./DSAGame/src/com/dsagame/codeforces) | **42** | Solutions across **19 contest packages** (`Div. 1+2 Pinely`, `Div. 2`, `Div. 3`, `Div. 4`, `Educational Rounds`) plus custom fast `BufferedReader`/`StringTokenizer` I/O template. |
| [`interviewbit/`](./DSAGame/src/com/dsagame/interviewbit), [`codingblock/`](./DSAGame/src/com/dsagame/codingblock), [`udemy/`](./DSAGame/src/com/dsagame/udemy) & [`practice/`](./DSAGame/src/com/dsagame/practice) | **43** | Bit manipulation, number theory/combinatorics, 1D DP, and miscellaneous pointer/tree problems. |
| **Total** | **461** | Pure Java source files (zero external runtime dependencies). |

---

## Core Algorithmic Domains Covered

- **Graph Algorithms:** BFS/DFS traversal, topological sort, cycle detection, shortest-path variants, connected components, and bipartite/grid search.
- **Dynamic Programming:** 0/1 & unbounded knapsack, subsequence/string DP, grid paths, tree DP, memoization-to-tabulation conversion, and space optimization.
- **Trees, BSTs & Heaps:** Iterative/recursive traversals, LCA, diameter, balanced/BST invariants, priority-queue streaming medians, and $k$-way merges.
- **Search, Greedy & Backtracking:** Monotonic binary search on answer, sliding-window & monotonic-deque invariants, bitmask/combinatorial pruning, and contest constructive algorithms.

---

## Compiling & Running Any Solution Locally

Every solution is a standalone Java source file under `DSAGame/src`:

```bash
# Compile any target class (example: Codeforces template or LeetCode problem)
javac -d build $(find DSAGame/src -name "*.java" | head -n 1)
```

Or open `DSAGame/` directly as a Java source root in IntelliJ IDEA or VS Code (Extension Pack for Java).
