package inteview;

import java.util.*;

/**
 * Java DSA Template Pack (Amazon-style)
 * - Sliding window
 * - Monotonic deque (sliding window max)
 * - Monotonic stack patterns
 * - BFS/DFS on grid
 * - BFS/DFS on graph
 * - Topological sort (Kahn)
 * - Binary search on answer
 * - Heaps: Top-K, merge K lists, median stream
 * - Trees: level order, validate BST
 * - LRU Cache
 */
public class Templates {

    // ---------------------------
    // 0) Common Helpers
    // ---------------------------

    static final int[] DR4 = {-1, 1, 0, 0};
    static final int[] DC4 = {0, 0, -1, 1};

    // Safe comparator helper
    static int cmpInt(int a, int b) { return Integer.compare(a, b); }

    // ---------------------------
    // 1) Sliding Window (Variable) - at most K "bad"
    // Example: Longest subarray with at most K zeros
    // ---------------------------
    static int longestAtMostKZeros(int[] a, int k) {
        int l = 0, bad = 0, ans = 0;
        for (int r = 0; r < a.length; r++) {
            if (a[r] == 0) bad++;
            while (bad > k) {
                if (a[l] == 0) bad--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    // ---------------------------
    // 2) Sliding Window Maximum (Monotonic Deque)
    // ---------------------------
    static int[] slidingWindowMax(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices, values decreasing

        for (int i = 0; i < n; i++) {
            // remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            // maintain decreasing
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.addLast(i);
            // window formed
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }

    // ---------------------------
    // 3) Monotonic Stack: Remove K Digits (classic)
    // ---------------------------
    static String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peekLast() > c) {
                st.pollLast();
                k--;
            }
            st.addLast(c);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pollLast();
            k--;
        }
        // build and strip leading zeros
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pollFirst());
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') i++;
        String ans = sb.substring(i);
        return ans.isEmpty() ? "0" : ans;
    }

    // ---------------------------
    // 4) Balanced Parentheses Check
    // ---------------------------
    static boolean isValidParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if ((c == ')' && t != '(') || (c == '}' && t != '{') || (c == ']' && t != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }

    // ---------------------------
    // 5) BFS Grid Template (multi-source BFS)
    // Example: Rotting Oranges
    // ---------------------------
    static int rottingOranges(int[][] g) {
        int m = g.length, n = g[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (g[r][c] == 2) q.add(new int[]{r, c});
                else if (g[r][c] == 1) fresh++;
            }
        }
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + DR4[d], nc = c + DC4[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (g[nr][nc] != 1) continue;
                    g[nr][nc] = 2;
                    fresh--;
                    q.add(new int[]{nr, nc});
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

    // ---------------------------
    // 6) DFS Grid Template
    // Example: Number of Islands
    // ---------------------------
    static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfsIsland(grid, r, c);
                }
            }
        }
        return count;
    }

    static void dfsIsland(char[][] g, int r, int c) {
        int m = g.length, n = g[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || g[r][c] != '1') return;
        g[r][c] = '0';
        for (int d = 0; d < 4; d++) dfsIsland(g, r + DR4[d], c + DC4[d]);
    }

    // ---------------------------
    // 7) Graph BFS/DFS Template (Adj list)
    // ---------------------------
    static List<Integer>[] buildGraph(int n, int[][] edges, boolean directed) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            if (!directed) g[v].add(u);
        }
        return g;
    }

    static void bfsGraph(List<Integer>[] g, int start) {
        boolean[] vis = new boolean[g.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // ---------------------------
    // 8) Topological Sort (Kahn) - Course Schedule II
    // ---------------------------
    static int[] topoOrder(int n, int[][] prereq) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int[] indeg = new int[n];

        for (int[] p : prereq) {
            int a = p[0], b = p[1]; // to take a you need b => edge b->a
            g[b].add(a);
            indeg[a]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        int[] order = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g[u]) {
                if (--indeg[v] == 0) q.add(v);
            }
        }
        return idx == n ? order : new int[0]; // empty => cycle
    }

    // ---------------------------
    // 9) Binary Search on Answer Template
    // Example: Koko eating bananas (min speed)
    // ---------------------------
    static int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 1;
        for (int p : piles) hi = Math.max(hi, p);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canEat(piles, h, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + speed - 1) / speed;
            if (hours > h) return false;
        }
        return true;
    }

    // ---------------------------
    // 10) Top-K Frequent Elements (HashMap + MinHeap size K)
    // ---------------------------
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[Math.min(k, pq.size())];
        for (int i = res.length - 1; i >= 0; i--) res[i] = pq.poll()[0];
        return res;
    }

    // ---------------------------
    // 11) Merge K Sorted Lists (Heap)
    // ---------------------------
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) if (node != null) pq.offer(node);

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) pq.offer(cur.next);
        }
        tail.next = null;
        return dummy.next;
    }

    // ---------------------------
    // 12) Median from Data Stream (Two Heaps)
    // ---------------------------
    static class MedianFinder {
        // maxHeap for lower half, minHeap for upper half
        private final PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
        private final PriorityQueue<Integer> hi = new PriorityQueue<>();

        public void addNum(int num) {
            if (lo.isEmpty() || num <= lo.peek()) lo.offer(num);
            else hi.offer(num);

            // rebalance sizes
            if (lo.size() > hi.size() + 1) hi.offer(lo.poll());
            else if (hi.size() > lo.size()) lo.offer(hi.poll());
        }

        public double findMedian() {
            if (lo.size() > hi.size()) return lo.peek();
            return (lo.peek() + hi.peek()) / 2.0;
        }
    }

    // ---------------------------
    // 13) Binary Tree Templates
    // ---------------------------
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    static boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validBST(TreeNode node, long lo, long hi) {
        if (node == null) return true;
        if (node.val <= lo || node.val >= hi) return false;
        return validBST(node.left, lo, node.val) && validBST(node.right, node.val, hi);
    }

    // ---------------------------
    // 14) LRU Cache (HashMap + Doubly Linked List)
    // ---------------------------
    static class LRUCache {
        static class Node {
            int key, val;
            Node prev, next;
            Node(int k, int v) { key = k; val = v; }
        }

        private final int cap;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(-1, -1); // dummy
        private final Node tail = new Node(-1, -1); // dummy

        public LRUCache(int capacity) {
            this.cap = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            moveToFront(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.val = value;
                moveToFront(node);
                return;
            }
            if (map.size() == cap) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node nn = new Node(key, value);
            addFront(nn);
            map.put(key, nn);
        }

        private void moveToFront(Node node) {
            remove(node);
            addFront(node);
        }

        private void addFront(Node node) {
            Node a = head.next;
            head.next = node;
            node.prev = head;
            node.next = a;
            a.prev = node;
        }

        private void remove(Node node) {
            Node p = node.prev, n = node.next;
            p.next = n;
            n.prev = p;
        }
    }

    // ---------------------------
    // 15) BONUS: Disjoint Set Union (Union-Find) - handy
    // ---------------------------
    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            while (p[x] != x) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return x;
        }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (r[ra] < r[rb]) p[ra] = rb;
            else if (r[ra] > r[rb]) p[rb] = ra;
            else { p[rb] = ra; r[ra]++; }
            return true;
        }
    }
}
