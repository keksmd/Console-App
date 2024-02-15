package Submarines;

public class Coordinates {
    private Long x; //Максимальное значение поля: 625, Поле не может быть null
    private Float y; //Значение поля должно быть больше -354, Поле не может быть null
    public Coordinates(Long x1,Float y1){
        this.x =x1;
        this.y =y1;
    }
}
