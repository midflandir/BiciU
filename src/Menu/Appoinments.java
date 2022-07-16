package Menu;

import Appointments.Appointment;
import Appointments.AppointmentStatus;
import Appointments.Type;

import java.time.LocalDate;
import java.time.*;
import java.time.temporal.TemporalAdjusters;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appoinments {

    private static Scanner in = new Scanner(System.in);
    private static List<Appointment> appointmentss = new ArrayList<Appointment>();

    public static void start() {
        int aux;

        try {

            System.out.println(" ___________..........___________" +
                    "\n" + "Sanipet - Veterinary care center" +
                    "\n" + "1. Create appointment. " +
                    "\n" + "2. Update appointment." +
                    "\n" + "3. Cancel appointment." +
                    "\n" + "4. Filter by day" +
                    "\n" + "5. Exit" +
                    "");
            aux = Integer.parseInt(in.nextLine());
            options(aux);


        } catch (Exception e) {
            System.out.println("invalid option");
        }

    }


    public static void options(int option) {

        switch (option) {
            case 1:
                Createappointment();
                break;
            case 2:
                Updateppointment();
                break;
            case 3:
                Cancelappointment();
                break;
            case 4:
                FilterAppointment();
            default:
                start();
        }
    }

    public static void Createappointment() {
        String aux;
        int auxb, auxc;
        Appointment appoint = new Appointment();

        System.out.println("Please enter the patient's Clinic number");
        aux = in.nextLine();
        appoint.setClinicNumber(aux);

        try {
            System.out.println("Please select appoinment type  \n" +
                    "   1. MEDICAL,\n" +
                    "   2. SURGERY,\n" +
                    "   3. AESTHETIC");
            auxb = Integer.parseInt(in.nextLine());
            if (auxb == 1) {
                appoint.setType(Type.MEDICAL);

            }
            if (auxb == 2) {
                appoint.setType(Type.SURGERY);
            }
            if (auxb == 3) {
                appoint.setType(Type.AESTHETIC);
            }
            if (auxb != 1 && auxb != 2 && auxb != 3) {
                System.out.println("invalid option");
            }
        } catch (Exception e) {
            System.out.println("invalid option");
        }

        appoint.setStatus(AppointmentStatus.NOT_STARTED);

        System.out.println("Please enter a Day\n" +
                "       1.  MONDAY\n" +
                "       2.  TUESDAY\n" +
                "       3.  WEDNESDAY\n" +
                "       4.  THURSDAY\n" +
                "       5.  FRIDAY\n" +
                "       6.  SATURDAY");
        auxb = Integer.parseInt(in.nextLine());

        LocalDate ld = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        System.out.println(ld);
        ld = ld.with(TemporalAdjusters.nextOrSame(DayOfWeek.of(auxb)));

        if (auxb >= 1 && auxb <= 5) {
            System.out.println("Please enter an hour between 8 and 19");
            auxb = Integer.parseInt(in.nextLine());
        }

        if (auxb == 6) {
            System.out.println("Please enter an hour between 9 and 15");
            auxb = Integer.parseInt(in.nextLine());
        }

        LocalDateTime ldt = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), auxb, 00);

        appoint.setDate(ldt);

        appointmentss.add(appoint);
    }


    public static void Updateppointment() {

        String aux;
        int auxb, auxc;
        System.out.println("Please enter the Day of the Appoinment to be cancelled \n" +
                "       1.  MONDAY\n" +
                "       2.  TUESDAY\n" +
                "       3.  WEDNESDAY\n" +
                "       4.  THURSDAY\n" +
                "       5.  FRIDAY\n" +
                "       6.  SATURDAY");
        auxb = Integer.parseInt(in.nextLine());

        System.out.println("Please enter the hour of the Appoinment to be cancelled ");
        auxc = Integer.parseInt(in.nextLine());

        for (int i = 0; i < appointmentss.size(); i++) { // start from index 0
            if (appointmentss.get(i).getDate().getDayOfWeek() == DayOfWeek.of(auxb) && appointmentss.get(i).getDate().getHour() == auxc) {
                System.out.println("you want to set this appointment status to please enter\n" +
                        "   1. FINISHED,\n" +
                        "   2. ABSENT,\n" +
                        "   3. Exit this menu");
                auxb = Integer.parseInt(in.nextLine());
                if (auxb == 1) {
                    appointmentss.get(i).setStatus(AppointmentStatus.FINISHED);
                    System.out.println("Appointment Updated");

                }
                if (auxb == 2) {
                    appointmentss.get(i).setStatus(AppointmentStatus.ABSENT);
                    System.out.println("Appointment Updated");
                }

            }
        }

    }


    public static void Cancelappointment() {

        String aux;
        int auxb, auxc;
        System.out.println("Please enter the Day of the Appoinment to be cancelled \n" +
                "       1.  MONDAY\n" +
                "       2.  TUESDAY\n" +
                "       3.  WEDNESDAY\n" +
                "       4.  THURSDAY\n" +
                "       5.  FRIDAY\n" +
                "       6.  SATURDAY");
        auxb = Integer.parseInt(in.nextLine());

        System.out.println("Please enter the hour of the Appoinment to be cancelled ");
        auxc = Integer.parseInt(in.nextLine());

        for (int i = 0; i < appointmentss.size(); i++) { // start from index 0
            if (appointmentss.get(i).getDate().getDayOfWeek() == DayOfWeek.of(auxb) && appointmentss.get(i).getDate().getHour() == auxc) {
                appointmentss.get(i).setStatus(AppointmentStatus.CANCELED);
                System.out.println(" Appointment Cancelled");
            }
        }

    }


    public static void FilterAppointment() {

        String aux;
        int auxb, auxc;
        System.out.println("Please enter a Day to filter\n" +
                "       1.  MONDAY\n" +
                "       2.  TUESDAY\n" +
                "       3.  WEDNESDAY\n" +
                "       4.  THURSDAY\n" +
                "       5.  FRIDAY\n" +
                "       6.  SATURDAY");
        auxb = Integer.parseInt(in.nextLine());

        for (int i = 0; i < appointmentss.size(); i++) { // start from index 0
            if (appointmentss.get(i).getDate().getDayOfWeek() == DayOfWeek.of(auxb)) {
                System.out.println(" Appointments for the day " + appointmentss.get(i).getDate().getDayOfWeek() +
                        "  a this hour" + appointmentss.get(i).getDate().getHour());
            }
        }

    }


}
