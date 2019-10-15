/**
 * Please do not steal.
 */
package game;

/**
 * @author San Chau
 *
 */
public class Board {
	
	//declares cities
	public static City miami = new City("Miami"),
			tampa = new City("Tampa"),
			jacksonville = new City("Jacksonville"),
			savannah = new City("Savannah"),
			raleigh = new City("Raleigh"),
			norfolk = new City("Norfolk"),
			washington = new City("Washington"),
			philadelphia = new City("Philadelphia"),
			newYork = new City("New York"),
			boston = new City("Boston"),
			buffalo = new City("Buffalo"),
			pittsburgh = new City("Pittsburgh"),
			detroit = new City("Detroit"),
			cincinnati = new City("Cincinnati"),
			knoxville = new City("Knoxville"),
			atlanta = new City("Atlanta"),
			birmingham = new City("Birmingham"),
			newOrleans = new City("New Orleans"),
			memphis = new City("Memphis"),
			stLouis = new City("St Louis"),
			chicago = new City("Chicago"),
			duluth = new City("Duluth"),
			minneapolis = new City("Minneapolis"),
			omaha = new City("Omaha"),
			kansasCity = new City("Kansas City"),
			oklahomaCity = new City("Oklahoma City"),
			dallas = new City("Dallas"),
			houston = new City("Houston"),
			fargo = new City("Fargo"),
			billings = new City("Billings"),
			cheyenne = new City("Cheyenne"),
			denver = new City("Denver"),
			santaFe = new City("Santa Fe"),
			phoenix = new City("Phoenix"),
			lasVegas = new City("Las Vegas"),
			saltLakeCity = new City("Salt Lake City"),
			boise = new City("Boise"),
			seattle = new City("Seattle"),
			portland = new City("Portland"),
			sanFrancisco = new City("San Francisco"),
			losAngeles = new City("Los Angeles"),
			sanDiego = new City("San Diego");
	
	//declares arrays of cities connections for each city
	private static City[] miamiC = {tampa},
			tampaC = {miami, jacksonville},
			jacksonvilleC = {tampa, newOrleans, birmingham, savannah},
			savannahC = {jacksonville, atlanta, raleigh},
			raleighC = {savannah, atlanta, cincinnati, pittsburgh, norfolk},
			norfolkC = {raleigh, washington},
			washingtonC = {norfolk, pittsburgh, philadelphia},
			philadelphiaC = {washington, newYork},
			newYorkC = {philadelphia, buffalo, boston},
			bostonC = {newYork},
			buffaloC = {newYork, pittsburgh, detroit},
			pittsburghC = {buffalo, washington, raleigh, cincinnati, detroit},
			detroitC = {pittsburgh, cincinnati, chicago, duluth, buffalo},
			cincinnatiC = {detroit, pittsburgh, raleigh, knoxville, stLouis, chicago},
			knoxvilleC = {cincinnati, atlanta},
			atlantaC = {knoxville, raleigh, savannah, birmingham, stLouis},
			birminghamC = {atlanta, jacksonville, newOrleans, memphis},
			newOrleansC = {birmingham, jacksonville, houston, dallas, memphis},
			memphisC = {newOrleans, dallas, oklahomaCity, kansasCity, stLouis, birmingham},
			stLouisC = {memphis, kansasCity, chicago, cincinnati, atlanta},
			chicagoC = {stLouis, kansasCity, omaha, minneapolis, duluth, detroit, cincinnati},
			duluthC = {chicago, minneapolis, fargo, detroit},
			minneapolisC = {duluth, chicago, omaha, cheyenne, billings, fargo},
			omahaC = {minneapolis, chicago, kansasCity, cheyenne},
			kansasCityC = {omaha, chicago, stLouis, memphis, oklahomaCity, santaFe, denver},
			oklahomaCityC = {kansasCity, memphis, dallas, santaFe},
			dallasC = {oklahomaCity, memphis, newOrleans, houston, santaFe},
			houstonC = {dallas, newOrleans, santaFe},
			fargoC = {duluth, minneapolis, billings},
			billingsC = {fargo, minneapolis, cheyenne, boise, seattle},
			cheyenneC = {billings, minneapolis, omaha, denver, boise},
			denverC = {cheyenne, kansasCity, santaFe, saltLakeCity},
			santaFeC = {denver, kansasCity, oklahomaCity, dallas, houston, phoenix, lasVegas, saltLakeCity},
			phoenixC = {santaFe, sanDiego, lasVegas},
			lasVegasC = {phoenix, sanDiego, losAngeles, sanFrancisco, saltLakeCity, santaFe},
			saltLakeCityC = {lasVegas, sanFrancisco, boise, denver, santaFe},
			boiseC = {saltLakeCity, sanFrancisco, portland, seattle, billings, cheyenne},
			seattleC = {boise, portland, billings},
			portlandC = {seattle, boise, sanFrancisco},
			sanFranciscoC = {portland, boise, saltLakeCity, lasVegas, losAngeles},
			losAngelesC = {sanFrancisco, lasVegas, sanDiego},
			sanDiegoC = {losAngeles, lasVegas, phoenix};
	
	//declares arrays of toll prices for each city
	private static int[] miamiT = {4},
			tampaT = {4, 4},
			jacksonvilleT = {4, 16, 9, 0},
			savannahT = {0, 7, 7},
			raleighT = {7, 7, 15, 7, 3},
			norfolkT = {3, 5},
			washingtonT = {5, 6, 3},
			philadelphiaT = {3, 0},
			newYorkT = {0, 8, 3},
			bostonT = {3},
			buffaloT = {8, 7, 7},
			pittsburghT = {7, 6, 7, 7, 6},
			detroitT = {6, 4, 7, 15, 7},
			cincinnatiT = {4, 7, 15, 6, 12, 7},
			knoxvilleT = {6, 5},
			atlantaT = {5, 7, 7, 3, 12},
			birminghamT = {3, 9, 11, 6},
			newOrleansT = {11, 16, 8, 12, 7},
			memphisT = {7, 12, 14, 12, 7, 6},
			stLouisT = {7, 6, 10, 12, 12},
			chicagoT = {10, 8, 13, 8, 12, 7, 7},
			duluthT = {12, 5, 6, 15},
			minneapolisT = {5, 8, 8, 18, 18, 6},
			omahaT = {8, 13, 5, 14},
			kansasCityT = {5, 8, 6, 12, 8, 16, 16},
			oklahomaCityT = {8, 14, 3, 15},
			dallasT = {3, 12, 12, 5, 16},
			houstonT = {5, 8, 21},
			fargoT = {6, 6, 17},
			billingsT = {17, 18, 9, 12, 9},
			cheyenneT = {9, 18, 14, 0, 24},
			denverT = {0, 16, 13, 21},
			santaFeT = {13, 16, 15, 16, 21, 18, 27, 28},
			phoenixT = {18, 14, 15},
			lasVegasT = {15, 9, 9, 14, 18, 27},
			saltLakeCityT = {18, 27, 8, 21, 28},
			boiseT = {8, 23, 13, 12, 12, 24},
			seattleT = {12, 3, 9},
			portlandT = {3, 13, 24},
			sanFranciscoT = {24, 23, 27, 14, 9},
			losAngelesT = {9, 9, 3},
			sanDiegoT = {3, 9, 14};
	
	//connects all cities together
	public Board() {
		miami.connectCities(miamiC, miamiT);
		tampa.connectCities(tampaC, tampaT);
		jacksonville.connectCities(jacksonvilleC, jacksonvilleT);
		savannah.connectCities(savannahC, savannahT);
		raleigh.connectCities(raleighC, raleighT);
		norfolk.connectCities(norfolkC, norfolkT);
		washington.connectCities(washingtonC, washingtonT);
		philadelphia.connectCities(philadelphiaC, philadelphiaT);
		newYork.connectCities(newYorkC, newYorkT);
		boston.connectCities(bostonC, bostonT);
		buffalo.connectCities(buffaloC, buffaloT);
		pittsburgh.connectCities(pittsburghC, pittsburghT);
		detroit.connectCities(detroitC, detroitT);
		cincinnati.connectCities(cincinnatiC, cincinnatiT);
		knoxville.connectCities(knoxvilleC, knoxvilleT);
		atlanta.connectCities(atlantaC, atlantaT);
		birmingham.connectCities(birminghamC, birminghamT);
		newOrleans.connectCities(newOrleansC, newOrleansT);
		memphis.connectCities(memphisC, memphisT);
		stLouis.connectCities(stLouisC, stLouisT);
		chicago.connectCities(chicagoC, chicagoT);
		duluth.connectCities(duluthC, duluthT);
		minneapolis.connectCities(minneapolisC, minneapolisT);
		omaha.connectCities(omahaC, omahaT);
		kansasCity.connectCities(kansasCityC, kansasCityT);
		oklahomaCity.connectCities(oklahomaCityC, oklahomaCityT);
		dallas.connectCities(dallasC, dallasT);
		houston.connectCities(houstonC, houstonT);
		fargo.connectCities(fargoC, fargoT);
		billings.connectCities(billingsC, billingsT);
		cheyenne.connectCities(cheyenneC, cheyenneT);
		denver.connectCities(denverC, denverT);
		santaFe.connectCities(santaFeC, santaFeT);
		phoenix.connectCities(phoenixC, phoenixT);
		lasVegas.connectCities(lasVegasC, lasVegasT);
		saltLakeCity.connectCities(saltLakeCityC, saltLakeCityT);
		boise.connectCities(boiseC, boiseT);
		seattle.connectCities(seattleC, seattleT);
		portland.connectCities(portlandC, portlandT);
		sanFrancisco.connectCities(sanFranciscoC, sanFranciscoT);
		losAngeles.connectCities(losAngelesC, losAngelesT);
		sanDiego.connectCities(sanDiegoC, sanDiegoT);
	}
	
	//calculates city and toll cost
	public static int getCityCost(City oldCity, City newCity) {
		int price = 0;
		price += oldCity.getTollTo(newCity);
		if(!newCity.isVacant(1)) {
			newCity.setToOwned(1);
			price += newCity.getPrice(1);
		}
		else if(!newCity.isVacant(2)) {
			newCity.setToOwned(2);
			price += newCity.getPrice(2);
		}
		else if(!newCity.isVacant(3)) {
			newCity.setToOwned(3);
			price += newCity.getPrice(3);
		}
		return price;
	}
}
