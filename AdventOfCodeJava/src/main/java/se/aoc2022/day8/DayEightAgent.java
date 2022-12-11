package se.aoc2022.day8;

import java.util.List;

public class DayEightAgent {

    int[][] forest;

    public DayEightAgent(List<String> fileContent) {
        int height = fileContent.size();
        int width = fileContent.get(0).length();
        forest = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = fileContent.get(i);
            for (int j = 0; j < width; j++) {
                forest[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
    }

    public int countVisibleTrees() {
        int height = forest.length;
        int width = forest[0].length;
        int trees = (2 * height) + (2 * width) - 4;

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                if (treeIsVisibleX(forest[y], x) || treeIsVisibleY(forest, x, y)) {
                    trees++;
                }
            }
        }
        return trees;
    }

    private boolean treeIsVisibleX(int[] row, int targetIndex) {
        int treeHeight = row[targetIndex];
        int left = 0;
        int right = 0;
        for (int i = 0; i < targetIndex; i++) {
            left = Math.max(left, row[i]);
        }
        for (int i = row.length - 1; i > targetIndex; i--) {
            right = Math.max(right, row[i]);
        }
        return treeHeight > left || treeHeight > right;
    }

    private boolean treeIsVisibleY(int[][] forest, int targetX, int targetY) {
        int treeHeight = forest[targetY][targetX];
        int up = 0;
        int down = 0;
        for (int i = 0; i < targetY; i++) {
            up = Math.max(up, forest[i][targetX]);
        }
        for (int i = forest.length - 1; i > targetY; i--) {
            down = Math.max(down, forest[i][targetX]);
        }
        return treeHeight > up || treeHeight > down;
    }

    public int maxScore() {
        int height = forest.length;
        int width = forest[0].length;
        int score = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                score = Math.max(score, treeScoreX(forest[y], x) * treeScoreY(forest, x, y));
            }
        }
        return score;
    }

    private int treeScoreX(int[] row, int targetIndex) {
        int treeHeight = row[targetIndex];
        int left = 0;
        int right = 0;
        for (int i = targetIndex - 1; i >= 0; i--) {
            left++;
            if (row[i] >= treeHeight) {
                break;
            }
        }
        for (int i = targetIndex + 1; i < row.length; i++) {
            right++;
            if (row[i] >= treeHeight) {
                break;
            }
        }
        return left * right;
    }

    private int treeScoreY(int[][] forest, int targetX, int targetY) {
        int treeHeight = forest[targetY][targetX];
        int up = 0;
        int down = 0;
        for (int i = targetY - 1; i >= 0; i--) {
            up++;
            if (forest[i][targetX] >= treeHeight) {
                break;
            }
        }
        for (int i = targetY + 1; i < forest.length; i++) {
            down++;
            if (forest[i][targetX] >= treeHeight) {
                break;
            }
        }
        return up * down;
    }

}
