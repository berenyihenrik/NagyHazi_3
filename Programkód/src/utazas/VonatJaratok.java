package utazas;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class VonatJaratok extends Jaratok  {
    private List<Vonat> tarolo;

    public VonatJaratok() {
        tarolo = new ArrayList<Vonat>();
    }

    
    /** 
     * Objektum hozzáadása a tárolóhoz
     * @param o az objektum
     */
    public void add(Jarmu o) {
        tarolo.add((Vonat)o);
    }

    
    /** 
     * Vonat lekérése a tárolóból
     * @param index a sorszám
     * @return Vonat a vonat
     */
    public Vonat get(int index) {
        return tarolo.get(index);
    }

    /** 
     * Vonat lekérése a tárolóból járatazonosító alapján
     * @param id a járatazonosító
     * @return Vonat
     */
    public Vonat getByID(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id().equals(id)) {
                return tarolo.get(i);
            }
        }
        return null;
    }

    
    /** 
     * Vonat eltávolítása a tárolóból
     * @param id azonosító
     */
    public void remove(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
                tarolo.remove(i);
            }
        }
    }

    
    /** 
     * A tároló mérete
     * @return int a méret
     */
    public int size() {
        return tarolo.size();
    }

    
    /** 
     * Azonosító ellenőrzése
     * @param id az azonosító
     * @return boolean igaz, ha a megadott azonosító már benne van a tárolóban
     */
    public boolean checkID(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * @return int
     */
    public int getRowCount() {
        return tarolo.size();
    }

    
    /** 
     * @return int
     */
    public int getColumnCount() {
        return 6;
    }

    /**
     * tároló szerializálása
     */
    public void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vonatjaratok.dat"));
            out.writeObject(tarolo);
            out.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * szerializált adatok beolvasása
     */
    public void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("vonatjaratok.dat"));
            tarolo = (List<Vonat>)in.readObject();
            in.close();
        } 
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /** 
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        Vonat v = tarolo.get(rowIndex);
        switch(columnIndex) {
            case 0: return v.get_id();
            case 1: return v.get_ind_all();
            case 2: return v.get_erkez_all();
            case 3: return v.get_ind_dt().toString();
            case 4: return v.get_erkez_dt().toString();
            default: return v.get_kocsik_szama();
        }
    }
        
    /** 
     * @param column
     * @return String
     */
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "Indulási állomás";
            case 2: return "Érkezési állomás";
            case 3: return "Indulási dátum";
            case 4: return "Érkezési dátum";
            default: return "Kocsik Száma";
        }
    }
}
