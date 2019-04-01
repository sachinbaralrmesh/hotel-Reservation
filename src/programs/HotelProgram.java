package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class HotelProgram {

	public static void main(String args[]) {
		int size = 3;
		String Selection;
		Scanner input = new Scanner(System.in);
		Bookingdetails bookingBetails;
		Booking bookingObj = new Booking();
		Map<String, List<Availability>> listRoomsAvailable = bookingObj.initMap(size);
		List<Bookingdetails> listRoombooking = new ArrayList<>();

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Welcome to hotel");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		while (true) {
			bookingBetails = new Bookingdetails();
			System.out.println("Please select one of the options.");
			System.out.println("A: Book A New Room.");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("D: View all.");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("E: Exit.");
			System.out.println("----------------------------------------------------------------------");
			Selection = input.next().toUpperCase();
			switch (Selection) {
			case "A":
				System.out.println("Please enter the stat date between 0 to 365");
				bookingBetails.setstartDate(input.nextInt());
				System.out.println("------------------------------------------------------------------");
				System.out.println("Please enter the end date between 0 to 365");
				bookingBetails.setendDate(input.nextInt());

				bookingObj.checkAvailability(listRoomsAvailable, listRoombooking, bookingBetails);

				break;
			case "D":

				/*
				 * for (Map.Entry<String, List<Availability>> entry :
				 * listRoomsAvailable.entrySet()) { System.out.println(entry.getKey() + "/" +
				 * entry.getValue()); }
				 */

				System.out.println("*********************************************************************");
				System.out.println("\t" + "   " + "StartDate" + "  " + "EndDate" + "  " + "Result:Accept/Decline");
				System.out.println("*********************************************************************");
				int count = 1;
				for (Bookingdetails itr : listRoombooking) {
					System.out.println("Boooking" + count++ + "\t" + itr.getstartDate() + "\t" + itr.getendDate() + "\t"
							+ itr.getResult());
				}
				System.out.println("*********************************************************************");

				break;
			case "E":
				input.close();
				System.out.println("");
				System.exit(0);
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}

	}

}