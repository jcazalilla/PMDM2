package morenocazalilla.jesusmaria;

public class Personaje {

    private String habilidades;
    private String name;
    private String description;
    private int photoID;


    public Personaje(String name, String description, int photoID, String habilidades) {
        this.name = name;
        this.description = description;
        this.photoID = photoID;
        this.habilidades = habilidades;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "habilidades='" + habilidades + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoID=" + photoID +
                '}';
    }
}
