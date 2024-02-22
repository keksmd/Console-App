package submarines;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import main.App;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        this.id = App.collection.size();
        this.creationDate = now();

        App.lastUpdated = LocalDate.now();


    }

    public SpaceMarine(){

    }

    public float getHeight(){
        return this.height;
    }

    public SpaceMarine update() {
        App.lastUpdated = LocalDate.now();

        this.name = (String) checkyRead("s", "more length 0", "Введите имя");

        this.coordinates = new Coordinates(
                (Long) checkyRead("l", "less than 626", "Введите целочисленную x-координату(x<=625"),
                (Float) checkyRead("f", "more than -353.0", "Введите y-координату в формате деcятичной дроби(y>=-354.0"));

        this.health = (Long) checkyRead("l", "Введите health");
        this.loyal = (Boolean) checkyRead("b", "Введите loyal (true/false)");
        this.height = (Float) checkyRead("f", "Введите height");
        this.weaponType = Weapon.choose(
                (String) checkyRead("s", """
                        Введите одно из названия для оружия:
                         BOLT_PISTOL,
                            COMBI_PLASMA_GUN,
                            GRENADE_LAUNCHER,
                            INFERNO_PISTOL,
                            MULTI_MELTA"""));
        this.chapter = new Chapter(
                (String) checkyRead("s", "Введите название главы"),
                (String) checkyRead("s", "Введите название мира"));
        return this;
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
        StringBuilder sb = new StringBuilder();
        sb.append("***** SpaceMarine Details *****\n");
        sb.append("ID="+getId()+"\n");
        sb.append("Name="+getName()+"\n");
        sb.append("health="+getHealth()+"\n");
        sb.append("Coordinates="+getCoordinates()+"\n");
        sb.append("loyal="+getLoyal()+"\n");
        sb.append("chapter="+getChapter()+"\n");
        sb.append("weapoonType="+getWeaponType()+"\n");
        sb.append("height="+getHeight()+"\n");
        sb.append("creationDate="+getCreationDate()+"\n");

        sb.append("*****************************");

        return sb.toString();
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
