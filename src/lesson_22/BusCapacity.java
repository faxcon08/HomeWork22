package lesson_22;

public enum BusCapacity {
    VERY_SMALL(null, 10),
    SMALL(10, 25),
    MIDDLE(25, 50),
    BIG(50, 80),
    VERY_BIG(80, 120);
    private Integer lowBorder;
    private Integer upBorder;

    BusCapacity(Integer lowBorder, Integer upBorder) {
        this.lowBorder = lowBorder;
        this.upBorder = upBorder;
    }

    @Override
    public String toString() {
        String low = (lowBorder != null) ? (" От " + lowBorder) : " ";
        String up = (upBorder != null) ? ("До " + upBorder) : "";
        return "Вместительность: " + low +" "+ up;
    }
    static public BusCapacity getBusCapacityByCount(int count) {
        BusCapacity errorValue = null;
        Integer minCount = 0;
        Integer maxCount = 120;
        if (count < minCount || count > maxCount) {
            System.err.println("Некорректное значение возможной вместимости для автобуса. ");
            return errorValue;
        }
        for (BusCapacity busCapacity : BusCapacity.values()) {
            Integer low = (busCapacity.lowBorder!=null)? busCapacity.lowBorder: minCount;
            Integer up = (busCapacity.upBorder!=null)? busCapacity.upBorder: maxCount;
            if( low <= count && up > count)
                return busCapacity;
        }
        System.err.println("Некорректное значение возможной вместимости для автобуса. ");
        return errorValue;
    }
}
