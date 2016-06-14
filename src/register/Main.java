package register;


/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Ivan Fazula", "0911514456"));
        register.addPerson(new Person("Juraj Kopor", "0902160456"));
        register.addPerson(new Person("Fero Hrasko", "0910123402"));
        register.addPerson(new Person("Peter Mrkvicka", "0901226012"));

        ConsoleUI ui = new ConsoleUI(register);
        ui.run(); 
    }
}
