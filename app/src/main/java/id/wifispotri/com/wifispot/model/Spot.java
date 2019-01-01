package id.wifispotri.com.wifispot.model;

public class Spot {
    private String idDb, idApi, namaSpot, jumlahSpot, lokasiSpot, longitude, latitude;
    private int gambar;

    public Spot() {
    }

    public Spot(String idDb) {
        this.idDb = idDb;
    }

    public Spot(String idApi, String namaSpot, String jumlahSpot, String lokasiSpot, String longitude, String latitude) {
        this.idApi = idApi;
        this.namaSpot = namaSpot;
        this.jumlahSpot = jumlahSpot;
        this.lokasiSpot = lokasiSpot;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Spot(String namaSpot, String jumlahSpot, String lokasiSpot) {
        this.namaSpot = namaSpot;
        this.jumlahSpot = jumlahSpot;
        this.lokasiSpot = lokasiSpot;
    }

    public Spot(String idDb, String idApi, String namaSpot, String jumlahSpot, String lokasiSpot, String longitude, String latitude) {
        this.idDb = idDb;
        this.idApi = idApi;
        this.namaSpot = namaSpot;
        this.jumlahSpot = jumlahSpot;
        this.lokasiSpot = lokasiSpot;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getIdDb() {
        return idDb;
    }

    public void setIdDb(String idDb) {
        this.idDb = idDb;
    }

    public String getIdApi() {
        return idApi;
    }

    public void setIdApi(String idApi) {
        this.idApi = idApi;
    }

    public String getNamaSpot() {
        return namaSpot;
    }

    public void setNamaSpot(String namaSpot) {
        this.namaSpot = namaSpot;
    }

    public String getJumlahSpot() {
        return jumlahSpot;
    }

    public void setJumlahSpot(String jumlahSpot) {
        this.jumlahSpot = jumlahSpot;
    }

    public String getLokasiSpot() {
        return lokasiSpot;
    }

    public void setLokasiSpot(String lokasiSpot) {
        this.lokasiSpot = lokasiSpot;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
