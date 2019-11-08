public class wateringFlowers {
    public static int wateringFlowers(int[] plants, int C) {
        if (plants.length == 0 || plants == null) {
            return -1;
        }

        int cur = C; // current water
        int n = plants.length; // plants' length
        int step = n; // assume we start off by setting at the end
        int i = n - 1;

        while (i >= 0) {
            int temp = Math.min(plants[i], cur); // current water to fill in
            plants[i] -= temp;
            cur -= temp;
            // water the next flower
            if (plants[i] == 0) {
                i--;
                continue;
            }
            // refill the water bottle and update the step
            if (cur == 0) {
                cur = C;
                step += i + 1;
            }
        }
        // the total steps needed to return is the step * 2 - n
        return (step * 2) - n;
    }


    public static void main(String[] args) {

        int[] plants = {2,4,5,1,2};
        int C = 6;
        int res = wateringFlowers(plants, C);
        System.out.println(res);

    }

}
