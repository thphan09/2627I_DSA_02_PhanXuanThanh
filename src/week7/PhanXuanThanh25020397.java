package week7;

import java.util.*;

public class PhanXuanThanh25020397 {

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        
        // Max-Heap lưu trữ nửa dưới của danh sách (các số nhỏ hơn)
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        // Min-Heap lưu trữ nửa trên của danh sách (các số lớn hơn)
        PriorityQueue<Integer> uppers = new PriorityQueue<>();

        for (int number : a) {
            // Thêm phần tử vào Heap phù hợp
            if (lowers.isEmpty() || number <= lowers.peek()) {
                lowers.add(number);
            } else {
                uppers.add(number);
            }

            // Cân bằng lại 2 Heap sao cho kích thước chênh lệch không vượt quá 1
            // Ưu tiên Max-Heap (lowers) giữ nhiều hơn 1 phần tử nếu tổng số phần tử là lẻ
            if (lowers.size() > uppers.size() + 1) {
                uppers.add(lowers.poll());
            } else if (uppers.size() > lowers.size()) {
                lowers.add(uppers.poll());
            }

            // Tính toán Median hiện tại
            if (lowers.size() == uppers.size()) {
                // Nếu tổng số phần tử chẵn, trung vị là trung bình cộng của 2 phần tử ở đỉnh 2 heap
                medians.add((lowers.peek() + uppers.peek()) / 2.0);
            } else {
                // Nếu lẻ, trung vị nằm ở đỉnh của Max-Heap
                medians.add((double) lowers.peek());
            }
        }

        return medians;
    }

    public static void main(String[] args) {
        // Test Case 1: Sample Input từ đề bài
        List<Integer> testCase1 = Arrays.asList(12, 4, 5, 3, 8, 7);
        System.out.println("Test Case 1 Input: " + testCase1);
        System.out.println("Output:");
        List<Double> result1 = runningMedian(testCase1);
        for (Double median : result1) {
            System.out.printf("%.1f\n", median);
        }

        System.out.println("\n--------------------------\n");

        // Test Case 2: Example từ phần mô tả của đề bài
        List<Integer> testCase2 = Arrays.asList(7, 3, 5, 2);
        System.out.println("Test Case 2 Input: " + testCase2);
        System.out.println("Output:");
        List<Double> result2 = runningMedian(testCase2);
        for (Double median : result2) {
            System.out.printf("%.1f\n", median);
        }
    }
}
