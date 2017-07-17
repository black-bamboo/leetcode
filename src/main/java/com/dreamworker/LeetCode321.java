package com.dreamworker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        PriorityQueue<QueueNode> queue1 = new PriorityQueue<QueueNode>(new Comparator<QueueNode>() {
            public int compare(QueueNode o1, QueueNode o2) {
                return o2.value - o1.value;
            }
        });
        int i = 0;
        for (int num : nums1) {
            queue1.offer(new QueueNode(num, i));
            i++;
        }

        PriorityQueue<QueueNode> queue2 = new PriorityQueue<QueueNode>(new Comparator<QueueNode>() {
            public int compare(QueueNode o1, QueueNode o2) {
                return o2.value - o1.value;
            }
        });
        i = 0;
        for (int num : nums2) {
            queue2.offer(new QueueNode(num, i));
            i++;
        }

        int current1 = -1;
        int current2 = -1;
        int ri = 0;
        int[] result = new int[k];
        for (i = 0; i < k; i++) {
            QueueNode value1 = queue1.poll();
            while (value1 != null && value1.index < current1) {
                value1 = queue1.poll();
            }
            QueueNode value2 = queue2.poll();
            while (value2 != null && value2.index < current2) {
                value2 = queue2.poll();
            }

            if (value1 != null && value2 != null) {
                if (value1.value > value2.value) {
                    if (nums1.length - value1.index - 1 + nums2.length - current2 - 1 >= k - i - 1) {
                        result[ri++] = value1.value;
                        current1 = value1.index;
                        queue2.offer(value2);
                    } else {
                        ArrayList<QueueNode> temp = new ArrayList<QueueNode>();
                        temp.add(value1);
                        value1 = queue1.poll();
                        while (value1 != null && value1.value < value2.value && nums1.length - value1.index - 1 + nums2.length - current2 - 1 < k - i - 1) {
                            temp.add(value1);
                            value1 = queue1.poll();
                        }
                        if (value1 == null) {
                            result[ri++] = value2.value;
                            current2 = value2.index;
                        } else {
                            result[ri++] = value1.value;
                            current1 = value1.index;
                            queue2.offer(value2);
                        }
                        for(QueueNode node : temp) {
                            queue1.offer(node);
                        }
                    }
                } else if (value1.value < value2.value) {
                    if (nums1.length - value1.index - 1 + nums2.length - current2 - 1 >= k - i - 1) {
                        result[ri++] = value2.value;
                        current2 = value2.index;
                        queue1.offer(value1);
                    } else {
                        ArrayList<QueueNode> temp = new ArrayList<QueueNode>();
                        temp.add(value2);
                        value2 = queue2.poll();
                        while (value2 != null && value2.value < value1.value && nums2.length - value2.index - 1 + nums1.length - current1 - 1 < k - i - 1) {
                            temp.add(value2);
                            value2 = queue2.poll();
                        }
                        if (value2 == null) {
                            result[ri++] = value1.value;
                            current1 = value1.index;
                        } else {
                            result[ri++] = value2.value;
                            current2 = value2.index;
                            queue1.offer(value1);
                        }
                        for(QueueNode node : temp) {
                            queue2.offer(node);
                        }
                    }
                } else {
                    // value1.value == value2.value
                    QueueNode node1 = queue1.poll();
                    QueueNode node2 = queue2.poll();
                    if (node1 == null) {
                        result[ri++] = value1.value;
                        current1 = value1.index;
                    } else if (node2 == null) {
                        result[ri++] = value2.value;
                        current2 = value2.index;
                    } else {
                        if (node1.value > node2.value && node1.index < value1.index) {
                            result[ri++] = value2.value;
                            current2 = value2.index;
                            queue1.offer(value1);
                        } else {
                            result[ri++] = value1.value;
                            current1 = value1.index;
                            queue2.offer(value2);
                        }
                    }
                    if (node1 != null) {
                        queue1.offer(node1);
                    }
                    if (node2 != null) {
                        queue2.offer(node2);
                    }
                }
            } else if (value1 != null) {
                ArrayList<QueueNode> temp = new ArrayList<QueueNode>();
                while (!queue1.isEmpty() && nums1.length - value1.index - 1 < k - i - 1) {
                    temp.add(value1);
                    value1 = queue1.poll();
                }
                result[ri++] = value1.value;
                current1++;
                for (QueueNode node : temp) {
                    queue1.offer(node);
                }
            } else if (value2 != null) {
                ArrayList<QueueNode> temp = new ArrayList<QueueNode>();
                while (!queue2.isEmpty() && nums2.length - value2.index - 1 < k -i - 1) {
                    temp.add(value2);
                    value2 = queue2.poll();
                }
                result[ri++] = value2.value;
                current2++;
                for (QueueNode node : temp) {
                    queue2.offer(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode321 solution = new LeetCode321();
        //int[] maxNumber = solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        //int[] maxNumber = solution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        //int[] maxNumber = solution.maxNumber(new int[]{5, 7, 3}, new int[]{4, 2, 3}, 3);
        int[] maxNumber = solution.maxNumber(new int[]{1, 6, 5, 4, 7, 3, 9, 5, 3, 7, 8, 4, 1, 1, 4}, new int[]{4, 3, 1, 3, 5, 9}, 21);
        for (int num : maxNumber) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    static class QueueNode {

        int value;

        int index;

        QueueNode(int value, int index) {
            this.value = value;
            this.index =index;
        }
    }
}
