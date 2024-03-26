package commands;
import utilites.interfaces.*;
import main.*;
public class Help extends Command implements methods {
    @Override
    public String toString() {
        return super.toString();
    }
    public Response calling(){
        Response resp = super.calling();
        resp.addMessage("help:| вывести справку по доступным командам\n info:| вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n show: | вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n add {element}:| добавить новый элемент в коллекцию\n update {id element}: | обновить значение элемента коллекции, id которого равен заданному\n remove_by_id {id}:| удалить элемент из коллекции по его id\n clear:| очистить коллекцию \nsave:| сохранить коллекцию в файл \nexecute_script {file_name}:| считать и исполнить скрипт из указанного файла.\n exit: | завершить программу (без сохранения в файл)\n remove_head:| вывести первый элемент коллекции и удалить его\n add_if_max {element}:| добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n add_if_min {element}:| добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n group_counting_by_weapon_type:| сгруппировать элементы коллекции по значению поля weaponType, вывести количество элементов в каждой группе\n filter_greater_than_height height:{height} | вывести элементы, значение поля height которых больше заданного \nprint_field_descending_loyal:| вывести значения поля loyal всех элементов в порядке убывания");
        return resp;
    }
}
