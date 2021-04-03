package UnionFind;

public class DemoEquations {

    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations1 = {"c==c", "b==d", "x!=z"};
        String[] equations2 = {"a==b", "b!=c", "c==a"};

        DemoEquations de = new DemoEquations();
        boolean b = de.equationsPossible(equations1);
        boolean b1 = de.equationsPossible(equations2);
        System.out.println(b);
        System.out.println(b1);

    }
}
