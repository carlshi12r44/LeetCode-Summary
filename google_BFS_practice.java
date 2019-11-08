package com.yifeng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    int x;
    int y;
    int val;
    Point() {
        this.x = 0;
        this.y = 0;
    }
    Point(int _x, int _y, int _val) {
        this.x = _x;
        this.y = _y;
        this.val = _val;
    }
}
public class google_BFS_practice {

    public static List<List<Integer>> shortestPathInMatrix(int[][] matrix, Point destination) {
        // shorest path BFS
        // 1 -- can go
        // 0 -- can't go
        // -1 -- goal
        // use BFS

        // save res list
        int res = 0;
        List<List<Integer>> resList = new ArrayList<>();
        // directions matrix
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

        // edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resList;
        }

        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(0, 0, matrix[0][0]);

        queue.offer(start);

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // BFS
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Point cur = queue.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(cur.x);
                temp.add(cur.y);
                resList.add(temp);
                // if it matches the -1, then the shortestpath could be return
                if (cur.val == -1) {
                    return resList;
                }
                visited[cur.x][cur.y] = true;
                for (int k = 0; k < 8; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if (isValid(nx, ny, matrix, visited)) {
                        queue.offer(new Point(nx, ny, matrix[nx][ny]));
                        visited[nx][ny] = true;
                    }
                }

            }

            res++;
        }

        // if can't find the shortest path, return null
        return null;
    }
    private static boolean isValid(int nx, int ny, int[][] matrix, boolean[][] visited) {
        int m = matrix.length, n = matrix[0].length;
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == 0 || visited[nx][ny]) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 1},
                          {0, 1, 1, 0},
                          {1, -1, 0, 1}};
        Point goal = new Point(2, 1, matrix[2][1]);
        List<List<Integer>> res = shortestPathInMatrix(matrix, goal);
        System.out.println(res);
        System.out.println(matrix[1][2]);
    }
}
