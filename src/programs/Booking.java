package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Booking {

	public void checkAvailability(Map<String, List<Availability>> listRoomsAvailable,
			List<Bookingdetails> listRoombooking, Bookingdetails bookingBetails) {
		int count = 0, j = 1, catchup = (bookingBetails.getendDate() - bookingBetails.getstartDate()) + 1;
		boolean check = false;
		String strTemp = "Room" + j;
		List<Availability> mapTemp = new ArrayList<>();

		if ((bookingBetails.getendDate() > -1 && bookingBetails.getendDate() < 364)
				&& (bookingBetails.getstartDate() > -1 && bookingBetails.getstartDate() < 364)
				&& (bookingBetails.getendDate() >= bookingBetails.getstartDate())) {

			while (j <= listRoomsAvailable.size()) {
				count = 0;
				mapTemp = new ArrayList<>(listRoomsAvailable.get("Room" + j));
				if (mapTemp.size() <= bookingBetails.getendDate()) {
					int k = mapTemp.size();
					while (k <= bookingBetails.getendDate()) {
						mapTemp.add(Availability.Available);
						k++;
					}
				}
				for (int i = bookingBetails.getstartDate(); i <= bookingBetails.getendDate(); i++) {
					if (mapTemp.get(i).equals(Availability.Accept)) {
						check = false;
						break;
					} else {
						count++;
					}
				}
				if (count == catchup) {
					strTemp = "Room" + j;
					for (int i = bookingBetails.getstartDate(); i <= bookingBetails.getendDate(); i++) {
						mapTemp.set(i, Availability.Accept);
					}
					listRoomsAvailable.put(strTemp, mapTemp);
					bookingBetails.setResult(Availability.Accept);
					listRoombooking.add(bookingBetails);
					check = true;
					break;
				}

				j++;
			}
		}

		if (!check) {
			bookingBetails.setResult(Availability.Decline);
			listRoombooking.add(bookingBetails);
			check = true;
		}

	}

	protected Map<String, List<Availability>> initMap(int size) {
		Map<String, List<Availability>> listRoomsAvailable = new HashMap<>();
		List<Availability> listTemp = new ArrayList<Availability>(364);
		listTemp.add(Availability.Available);
		for (int i = 1; i <= size; i++) {
			listRoomsAvailable.put("Room" + i, listTemp);

		}
		return listRoomsAvailable;
	}
}