public class Main {
    public static void main(String[] args) throws СhangeDriversLicense, СhangeDriversLicenseBus {

        Car ladaKalina = new Car("Lada", "Kalina", "бензин", "седан");
//        Car bmw5 = new Car("BMW","X5","бензин","хэтчбэк");
//        Car kiaRio = new Car("Kia","Rio","дизель",1.6);
//
        Trucks kamaz = new Trucks("Kamaz", "3008", "дизель", 3f);
        Trucks maz = new Trucks("Maz", "4008", "дизель", 17);
//
        Bus paz = new Bus("Паз", "2645", "дизель", 30);
//
//        paz.start();
//        paz.stop();
//
        DrB fedorovD = new DrB("Федоров Федор Федорович", 6, ladaKalina, Dr.DL_B);

        ladaKalina.passDiagnostics(fedorovD);

        DrC fedorovC = new DrC("Федоров Федор Федорович", 6, maz, Dr.DL_C);
        maz.passDiagnostics(fedorovC);
        passD(paz, ladaKalina, maz, kamaz);
    }

    // Прошграмма которая проверяет, что все объекты всех классов прошли диагностику.
    public static void passD(Transport... transports) throws СhangeDriversLicenseBus {
        for (Transport tr : transports) {
            try {
                if (tr.getClass() == Bus.class) {
                    throw new СhangeDriversLicenseBus();
                }
                if (tr.isDiagnostic()) {
                    System.out.println("Диагностика пройдена" + tr.isDiagnostic()
                            + " " + tr.getBrand() + " " + tr.getModel());
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (СhangeDriversLicenseBus e) {
                e.getMessage();
            }
        }

    }
}
