import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ans = new int[0];
        new Solution().spiralOrder(arr);
    }

    // 踏踏实实干就完了
    public int[] spiralOrder(int[][] matrix) {
        int[] ans = new int[matrix[0].length * matrix.length];
        int[][] route = new int[matrix.length][matrix[0].length];
        Vector pos = new Vector(0, 0);
        Direction direction = Direction.RIGHT;
        int i = 0;
        while (i < ans.length) {
            while (pos.x < matrix.length && 0 <= pos.x && 0 <= pos.y && pos.y < matrix[0].length && route[pos.x][pos.y] != 1) {
                ans[i++] = matrix[pos.x][pos.y];
                route[pos.x][pos.y] = 1;
                pos.forward(direction.v);
            }
            pos.back(direction.v);
            direction = direction.turn();
            pos.forward(direction.v);
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }
}

// 定义好四个方向才行
class Vector {
    int x;
    int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void forward(Vector v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void back(Vector v) {
        this.x -= v.x;
        this.y -= v.y;
    }
}

enum Direction {
    RIGHT(new Vector(0,1)),
    DOWN(new Vector(1, 0)),
    LEFT(new Vector(0, -1)),
    UP(new Vector(-1, 0));
    public final Vector v;

    Direction(Vector vector) {
        this.v = vector;
    }

    public Direction turn() {
        if (this == RIGHT) {
            return DOWN;
        } else if (this == DOWN) {
            return LEFT;
        } else if (this == LEFT) {
            return UP;
        } else if (this == UP) {
            return RIGHT;
        }else {
            throw new IllegalStateException("Invalid direction");
        }
    }
}