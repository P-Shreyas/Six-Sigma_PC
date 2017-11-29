public class Store {
    private double value;
    private String label;


    public double getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    Store(String label,double value)
    {
        this.label=label;
        this.value=value;
    }
}
