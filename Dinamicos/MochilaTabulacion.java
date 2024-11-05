public class MochilaTabulacion {
    public static int mochila(int pesoMaximo, int[] valores, int[] pesos) {
        int n = valores.length;
        int[][] dp = new int[n + 1][pesoMaximo + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= pesoMaximo; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][pesoMaximo];
    }

    public static void main(String[] args) {
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        int pesoMaximo = 8;
        System.out.println("Valor máximo (Tabulación): " + mochila(pesoMaximo, valores, pesos));
    }
}
