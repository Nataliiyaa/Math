package Math;

public class Vector extends Matrix{
    private String type = "Vector-column";

    Vector(double[] data) {
        super(data.length, 1, data);
    }

    protected Vector(int row, double[] base) {
        super(row, 1, base);
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

    @Override
    public void print() {
        super.print();
        System.out.print(getType()+"\n");
    }
}
