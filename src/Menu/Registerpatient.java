package Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Patient.Cat;
import Patient.Dog;
import Patient.Patient;
import Patient.Owner;

public class Registerpatient {

    private static Scanner in = new Scanner(System.in);
    private static List<Cat> cats = new ArrayList<Cat>();
    private static List<Dog> dogs = new ArrayList<Dog>();


    public static void register() {
        int aux;

        try {
            System.out.println("press 1 to cat or 2 for dog");
            aux = Integer.parseInt(in.nextLine());
            if (aux == 1) {
                registercats();
            }
            if (aux == 2) {
                registerdogs();
            }
            if (aux != 1 && aux != 2) {
                System.out.println("invalid option");
            }
        } catch (Exception e) {
            System.out.println("invalid option");
        }

    }


    public static void registercats() {
        String aux;
        int auxb;
        Cat catpatient = new Cat();

        System.out.println("Please enter the cat's Clinic number");
        aux = in.nextLine();
        catpatient.setClinicNumber(aux);

        System.out.println("Please enter the cat's name");
        aux = in.nextLine();
        catpatient.setName(aux);

        System.out.println("Please enter the cat's breed");
        aux = in.nextLine();
        catpatient.setBreed(aux);

        try {
            System.out.println("Is the cat Vaccinated 1. Yes 2. No");
            auxb = Integer.parseInt(in.nextLine());
            if (auxb == 1) {
                catpatient.setVaccinated(true);
            }
            if (auxb == 2) {
                catpatient.setVaccinated(false);
            }
            if (auxb != 1 && auxb != 2) {
                System.out.println("invalid option");
            }
        } catch (Exception e) {
            System.out.println("invalid option");
        }

        System.out.println("Please Enter desparasitation Date");
        aux = in.nextLine();
        catpatient.setDesparasitationDate(aux);


        catpatient.setOwners(registerwoner());

        cats.add(catpatient);
    }

    public static void registerdogs() {
        String aux;
        int auxb;
        Dog dogpatient = new Dog();

        System.out.println("Please enter the dog's Clinic number");
        aux = in.nextLine();
        dogpatient.setClinicNumber(aux);

        System.out.println("Please enter the dog's name");
        aux = in.nextLine();
        dogpatient.setName(aux);

        System.out.println("Please enter the dog's breed");
        aux = in.nextLine();
        dogpatient.setBreed(aux);

        try {
            System.out.println("Is the cat Vaccinated 1. Yes 2. No");
            auxb = Integer.parseInt(in.nextLine());
            if (auxb == 1) {
                dogpatient.setVaccinated(true);
            }
            if (auxb == 2) {
                dogpatient.setVaccinated(false);
            }
            if (auxb != 1 || auxb != 2) {
                System.out.println("invalid option");
            }
        } catch (Exception e) {
            System.out.println("invalid option");
        }

        System.out.println("Please Enter desparasitation Date");
        aux = in.nextLine();
        dogpatient.setDesparasitationDate(aux);


        dogpatient.setOwners(registerwoner());

        dogs.add(dogpatient);
    }


    public static Owner registerwoner() {
        Owner catowner = new Owner();
        String aux;

        System.out.println("Please enter owner DNI");
        aux = in.nextLine();
        catowner.setDNI(aux);

        System.out.println("Please enter the owner's name");
        aux = in.nextLine();
        catowner.setName(aux);

        System.out.println("Please enter the owner's cellphone");
        aux = in.nextLine();
        catowner.setCellphone(aux);

        try {
            System.out.println("Please enter the owner's age");
            aux = in.nextLine();
            catowner.setAge(Integer.parseInt(aux));
        } catch (Exception e) {
            System.out.println("Error - invalid age");
        }

        return catowner;
    }


}