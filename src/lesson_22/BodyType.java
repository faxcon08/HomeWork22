package lesson_22;

public enum BodyType {
    SEDAN("Cедан"),
    HATCHBACK("Хэтчбэк"),
    COUPE("Купэ"),
    UNIVERSALIS  ("Универсал"),
    SUV("Внедорожник"),
    CROSSOVER("Кроссовер"),
    PICKUP("Пикап"),
    VAN("Фургон"),
    MINIVAN("Минивэн");
    final private String bodyType;

    BodyType(String bodyType) {
        this.bodyType=bodyType;
    }

    @Override
    public String toString() {
        return this.bodyType;
    }
}
