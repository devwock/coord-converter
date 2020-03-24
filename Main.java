public class Main {
	public static void main(String[] args) {
		CoordConverter coordConverter = new CoordConverter();
		double degrees = coordConverter.toDecimalDegrees("373356.0");
		System.out.println(degrees);
		double dms = coordConverter.toDMS("37.565558");
		System.out.println(dms);
	}
}
