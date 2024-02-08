package Submarines;

import Main.App;

import java.lang.reflect.Field;

import static java.time.LocalDateTime.now;
import static utilites.CheckingReader.checkyRead;

public class SpaceMarine {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long health; //Значение поля должно быть больше 0
    private Boolean loyal; //Поле может быть null
    private float height;
    private Weapon weaponType; //Поле может быть null
    private Chapter chapter; //Поле не может быть null
    public SpaceMarine(String n,Coordinates c,long h,Boolean l,float height,Weapon gun,Chapter ch){
        this.name = n;
        this.health = h;
        this.coordinates = c;
        this.loyal = l;
        this.weaponType = gun;
        this.chapter = ch;
        this.height = height;
        this.id = App.que.size();
        this.creationDate = now();

    }
    public SpaceMarine update(){

                this.name = (String) checkyRead("s","more length 0","Введите имя");

                this.coordinates = new Coordinates(
                        (Long)checkyRead("l","less than 626","Введите целочисленную x-координату(x<=625") ,
                        (Float) checkyRead("f","more than -353.0","Введите y-координату в формате деcятичной дроби(y>=-354.0"));

                this.health = (Long)checkyRead("l","Введите health");
                this.loyal = (Boolean) checkyRead("b","Введите loyal (true/false)");
                this.height = (Float)checkyRead("f","Введите height");
                this.weaponType = Weapon.choose(
                        (String)checkyRead("s","Введите одно из названия для оружия:\n BOLT_PISTOL,\n" +
                                "    COMBI_PLASMA_GUN,\n" +
                                "    GRENADE_LAUNCHER,\n" +
                                "    INFERNO_PISTOL,\n" +
                                "    MULTI_MELTA"));
                this.chapter = new Chapter(
                        (String)checkyRead("s","Введите название главы"),
                        (String)checkyRead("s","Введите название мира") );
        return this;
    }
    public Boolean getLoyal(){
        return this.loyal;
    }
    public int getId(){
        return id;
    }

    public Weapon getWeaponType() {
        return weaponType;

    }
    public void describe(){
        for(Field f :SpaceMarine.class.getDeclaredFields()){
            System.out.println();
            System.out.printf("%s : %s%n",f.getName(),String.valueOf(f.getGenericType()));
        }
    }

    public String getName(String name) {
        return name;
    }
}
