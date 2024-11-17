package Math;

public class Vector extends Matrix{
    private String type = "Vector-column";

    Vector(double[] data) {
        super(data.length, 1, data);
    }



    protected Vector(int row, double[] data) {
        super(row, 1, data);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }



    @Override
    public void transpose() {
        super.transpose();
        switch (type){
            case "Vector-column": {setType("Vector-row"); break;}
            case "Vector-row": setType("Vector-column");
        }
    }


    private static final float EPSILON = 1e-10f;

    public float length() {
        double[] data = getData();
        double lenSqr = 0;
        for (double item : data) {
            lenSqr += item * item;
        }
        if (lenSqr < EPSILON)
            return 0;
        return (float)Math.sqrt(lenSqr);
    }


    @Override
    public void print() {
        super.print();
        System.out.print(getType()+"\n");
    }
}
