class Presum {
    public static void main(String[] args) {
        int[] A = {-1, -1, 1};   // change test here
        int C = 2;

        int prefix = 0;
        int minPrefix = 0;
        int maxPrefix = 0;

        for (int x : A) {
            prefix += x;
            System.out.println("Prefix: "+prefix);
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
            System.out.println("min "+ minPrefix);
            System.out.println("max "+ maxPrefix);
        }

        int lowerBound = -minPrefix;
        int upperBound = C - maxPrefix;
        System.out.println(upperBound);

        int X;
        if (lowerBound <= upperBound) {
            X = Math.max(0, lowerBound);
        } else {
            // unavoidable disturbance, clamp
            X = Math.min(C, Math.max(0, lowerBound));
        }

        System.out.println(X);
    }
}

/*
You have an oil tank with a capacity of C litres that can be bought and sold by N people. The people
are standing in a queue are served sequentially in the order of array A.Some of them want to sell a 
litre of oil and some of them want to buy a litre of oil and A describes this.
Here, A[i] = 1 denotes that the person wants to sell a litre of oil and A[i] = -1 denotes that the person
wants to buy a litre of oil. When a person wants to sell a litre of oil but the tank is full, they cannot 
sell it and become upset. Similarly, when a person wants to buy a litre of oil but the tank is empty, they cannot
buy it andbecome upset. Both these cases cause disturbances. You can minimize the disturbance by filling the tank
initially with a certain X litres of oil. Find the minimum initial amount of oil X that results
in the least number of disturbances.

    Input Format
        * The first line contains an integer, N, denoting the number of elements in A.
        * The next line contains an integer, C, denoting the capacity of the tank.
        * Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing A[i].
    Explanation:
        * Given N = 3, C = 3, A = [-1, 1, 1].
        -> To avoid disturbance for Person 1, we need at least 1 liter in the tank initially.
        * After Person 1 buys 1 liter, the tank will be empty.
        * Person 2 sells 1 liter, so the tank will have 1 liter.
        * Person 3 sells another liter, so the tank will have 2 liters.
        * The minimum initial amount X needed to achieve the least number of disturbances is 1 liter
*/

