package _2025.subjects._4_stack;

import java.util.Stack;

/**
 * 小行星碰撞
 *
 * @author 佳叙
 * @date 2025/4/3
 * @description <a href="https://leetcode.cn/problems/asteroid-collision/description/"/>
 */
public class _735_asteroid_collision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < asteroids.length) {
            if (asteroids[i] < 0) {
                if (!stack.isEmpty() && stack.peek() > 0) {
                    int collision = asteroids[i] + stack.peek();

                    if (collision == 0) {
                        stack.pop();
                        i++;
                    }
                    else if (collision < 0) {
                        stack.pop();
                    }
                    else {
                        i++;
                    }
                } else {
                    stack.push(asteroids[i]);
                    i++;
                }
            }
            else {
                stack.push(asteroids[i]);
                i++;
            }
        }

        int index = stack.size() - 1;
        int[] arr = new int[stack.size()];
        while (!stack.isEmpty()) {
            arr[index--] = stack.pop();
        }

        return arr;
    }

}