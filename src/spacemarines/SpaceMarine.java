package spacemarines;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import main.CollectionManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static utilites.CheckingReader.checkyRead;

public class SpaceMarine implements Comparable<SpaceMarine>  {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    //@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long health; //Значение поля должно быть больше 0
    private Boolean loyal; //Поле может быть null
    private float height;
    private Weapon weaponType; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(String n, Coordinates c, long h, Boolean l, float height, Weapon gun, Chapter ch) {
        super();
        this.name = n;
        this.health = h;
        this.coordinates = c;
        this.loyal = l;
        this.weaponType = gun;
        this.chapter = ch;
        this.height = height;
        this.id = CollectionManager.collection.size();
        this.creationDate = now();



    }

    public SpaceMarine(){

    }

    public float getHeight(){
        return this.height;
    }

    public void update(String[] input) {
        ArrayList<String> args = (ArrayList<String>) Arrays.stream(input).collect(Collectors.toList());


        this.name = args.get(0);
        this.coordinates = new Coordinates(
                (Long) checkyRead("l", "less than 626", "Введите целочисленную x-координату(x<=625","Sin"),
                (Float) checkyRead("f", "more than -353.0", "Введите y-координату в формате деcятичной дроби(y>=-354.0","sin"));

        this.health = (Long) checkyRead("l","more than 0","",args.get(1));
        this.loyal =(Boolean) checkyRead("b",args.get(2));
        this.height = (Float)checkyRead("f",args.get(3));
        this.weaponType = Weapon.choose(
                (String) checkyRead("s","is weapon", """
                        Введите одно из названия для оружия:
                            BOLT_PISTOL,
                            COMBI_PLASMA_GUN,
                            GRENADE_LAUNCHER,
                            INFERNO_PISTOL,
                            MULTI_MELTA""","sin"));
        this.chapter = new Chapter(
                (String) checkyRead("s","more length 0", "Введите название главы","sin"),
                (String) checkyRead("s","more length 0", "Введите название мира","sin"));
    }

    public long getHealth() {
        return health;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Boolean getLoyal() {
        return this.loyal;
    }

    public int getId() {
        return id;
    }

    public Weapon getWeaponType() {
        return weaponType;

    }

    @Override
    public String toString(){

        return "***** SpaceMarine Details *****\n" +
                "ID=" + getId() + "\n" +
                "Name=" + getName() + "\n" +
                "health=" + getHealth() + "\n" +
                "Coordinates=" + getCoordinates() + "\n" +
                "loyal=" + getLoyal() + "\n" +
                "chapter=" + getChapter() + "\n" +
                "weapoonType=" + getWeaponType() + "\n" +
                "height=" + getHeight() + "\n" +
                "creationDate=" + getCreationDate() + "\n" +
                "*****************************";
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(SpaceMarine other) {
        return this.name.compareTo(other.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }


    public void setLoyal(Boolean loyal) {
        this.loyal = loyal;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHealth(long health) {
        this.health = health;
    }
}
