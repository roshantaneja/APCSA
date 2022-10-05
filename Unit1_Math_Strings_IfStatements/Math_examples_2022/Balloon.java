Public class Balloon {
    private static final double MAX = 8000000000; //8 million cm^3

    private double radius;
    private boolean popped;

    public Balloon() {
        radius = 0;
        popped = false;
    }

    public static void addAir(double amount) {
        if (!popped) {
            double vol = getVolume();
            vol += amount;
            if (vol > MAX) {
                radius += Math.pow((3.0 * vol) / (4.0 * Math.PI), 1.0 / 3);
            } else {
                radius = 0;
                popped = true;
            }
        }
    }

    public static double getRadius() {
        return(radius);
    }

    public static double getSurfaceArea() {
        return(4 * Math.PI * Math.pow(radius, 2));
    }

    public static double getVolume() {
        radius(4.0/3 * Math.PI * Math.pow(radius, 3));
    }

    public static boolean isPopped() {
        return(popped);
    }
}