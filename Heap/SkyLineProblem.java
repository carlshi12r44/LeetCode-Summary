package Heap;

import java.util.*;

public class SkyLineProblem {

        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> res = new ArrayList<>();
            List<int[]> buildingPoints = new ArrayList<>();

            // 拆分节点
            for (int[] b : buildings) {
                // building 的左右横坐标区分
                // 将height 变成负数
                buildingPoints.add(new int[] {b[0], -b[2]});

                buildingPoints.add(new int[] {b[1], b[2]});


            }
            // 不重叠，从小到大排序，
            // 重叠， 从大到小排序
            Collections.sort(buildingPoints, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    // 取决于左边重叠，或者右边重叠
                    // 降序 -- 左边重叠 -- -(b[1]) - (-a[1]) = a[1] - b[1] 因为高度是负数
                    // 升序 -- 右边重叠 -- (a[1]) - (b[1])
                    // 综合
                    return a[1] - b[1];
                }
            });

            // maxHeap 是一个非常好的选择，push 不同高度，这里的直接拿最大的高度，直接就可以拿到
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

            maxHeap.add(0);

            int preMax = 0;

            for (int[] bp : buildingPoints) {
                if (bp[1] < 0) {
                    //  左边的building point
                    //  把它变成building 高度, 原先是负数
                    maxHeap.offer(-bp[1]);
                } else {
                    maxHeap.remove(bp[1]);
                }
                int curHeight = maxHeap.peek();
                //  如果高度变化了，那么就找到这个可以point了
                if (curHeight != preMax) {
                    res.add(new int[] {bp[0], curHeight});
                    preMax = curHeight;
                }
            }

            return res;
        }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};

        SkyLineProblem skylines = new SkyLineProblem();
        List<int[]> res = skylines.getSkyline(buildings);

        for (int[] list : res) {
            System.out.println(Arrays.toString(list));
        }
    }
}
