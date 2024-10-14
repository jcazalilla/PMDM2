package morenocazalilla.jesusmaria;

public class Personaje {

    String name;
    String description;
    int photoID;


    public Personaje(String name, String description, int photoID) {
        this.name = name;
        this.description = description;
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

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
