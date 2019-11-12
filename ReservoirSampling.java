import java.util.Random;

public class ReservoirSampling {

    public int[] reservoirSampling(int[] stream, int k) {
        Random rmd = new Random();
        int[] res = new int[k];

        int[] clone = stream.clone();

        // 开始从 k + 1 去取
        for (int i = k; i < stream.length; i++) {
            int random = rmd.nextInt(i + 1);
            if (random < k) {
                clone[random] = stream[i];
            }
        }


        return clone;

    }
}
