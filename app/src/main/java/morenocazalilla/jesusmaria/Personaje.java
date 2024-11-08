package morenocazalilla.jesusmaria;

public class Personaje {
    String name;
    String description;

    public Personaje(String name, String description, int photoID, String habilidades) {
        this.name = name;
        this.description = description;
        this.habilidades = habilidades;
        this.photoID = photoID;
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

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    String habilidades;
    int photoID;

}
