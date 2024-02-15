package Commands;
import utilites.interfaces.*;
import Main.*;
public class Help extends Command implements methods {
    public boolean calling(){
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                remove_head : вывести первый элемент коллекции и удалить его
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                group_counting_by_weapon_type : сгруппировать элементы коллекции по значению поля weaponType, вывести количество элементов в каждой группе
                filter_greater_than_height height : вывести элементы, значение поля height которых больше заданного
                print_field_descending_loyal : вывести значения поля loyal всех элементов в порядке убывания""");
        return true;
    }
}
