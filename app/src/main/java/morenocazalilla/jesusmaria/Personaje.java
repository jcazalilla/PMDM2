package morenocazalilla.jesusmaria;

public class Personaje {
    String name;
    String description;
    String ability;
    int photoID;

    public Personaje(String name, String description, String ability, int photoID) {
        this.name = name;
        this.description = description;
        this.ability = ability;
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

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
}
