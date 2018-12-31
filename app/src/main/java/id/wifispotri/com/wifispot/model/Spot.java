package id.wifispotri.com.wifispot.model;

public class Spot {
    private String id, namaSpot, jumlahSpot, lokasSpot, longitude, latitude;
    private int gambar;

    public Spot(String namaSpot, String jumlahSpot, String lokasSpot) {
        this.namaSpot = namaSpot;
        this.jumlahSpot = jumlahSpot;
        this.lokasSpot = lokasSpot;
    }

    public Spot(String id, String namaSpot, String jumlahSpot, String lokasSpot, String longitude, String latitude, int gambar) {
        this.id = id;
        this.namaSpot = namaSpot;
        this.jumlahSpot = jumlahSpot;
        this.lokasSpot = lokasSpot;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gambar = gambar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLokasSpot() {
        return lokasSpot;
    }

    public void setLokasSpot(String lokasSpot) {
        this.lokasSpot = lokasSpot;
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
