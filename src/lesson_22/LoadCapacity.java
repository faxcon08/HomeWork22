package lesson_22;

public enum LoadCapacity {
    N1(null, 3.5f),
    N2(3.5f,12f),
    N3(12f,null);

    private Float lowBorder;
    private Float upBorder;

    LoadCapacity(Float lowBorder, Float upBorder) {
        this.lowBorder=lowBorder;
        this.upBorder=upBorder;
    }

    @Override
    public String toString() {
        String low = (lowBorder!=null)? (" От "+lowBorder) : "";
        String up = (upBorder!=null)? (" До "+upBorder): "";
        return "Грузоподьемность: "+low+" "+up;
    }

    static public LoadCapacity getLoadCapacityByWeight(float weight) {
        LoadCapacity defaultValue = null;
        Float maxPossibleCapacity = 1000f;
        Float minCapacity = 0f;
        if (weight < 0 || weight > maxPossibleCapacity) {
            System.err.println("Некорретное значение возможной грузоподьемности грузовика.");
            return defaultValue;
        }
        for (LoadCapacity loadCapacity : LoadCapacity.values()) {
            Float low = (loadCapacity.lowBorder!=null)? loadCapacity.lowBorder: minCapacity;
            Float up = (loadCapacity.upBorder!=null)? loadCapacity.upBorder: maxPossibleCapacity;
            if(low <=weight && up>weight)
                return loadCapacity;
        }
        System.err.println("Некорретное значение возможной грузоподьемности грузовика.");
        return defaultValue;
    }
}
