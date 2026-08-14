class Solution {

    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();

        for (String s : deadends) {
            dead.add(s);
        }

        // Starting point itself is blocked
        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                // Try all 4 wheels
                for (int j = 0; j < 4; j++) {

                    // Turn forward
                    String next = turn(current, j, 1);

                    if (!dead.contains(next) &&
                        !visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }

                    // Turn backward
                    next = turn(current, j, -1);

                    if (!dead.contains(next) &&
                        !visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }

    private String turn(String current, int index, int direction) {

        char[] chars = current.toCharArray();

        if (direction == 1) {
            if (chars[index] == '9') {
                chars[index] = '0';
            } else {
                chars[index]++;
            }
        } else {
            if (chars[index] == '0') {
                chars[index] = '9';
            } else {
                chars[index]--;
            }
        }

        return new String(chars);
    }
}