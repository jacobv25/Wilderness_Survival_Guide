package edu.miracosta.finalprojecttest.model.enviroment;
/**
 * Item.java: A class that creates an item object and holds its parameters
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */
public class Item {

    private String imageName;
    private String name;
    private int count;
    /**
     * A full consturctor used to create an object with specific parameters passed in
     * @param imageName - The name of the animal
     * @param name - The description of the animal
     * @param count - The image of the animal
     */
    public Item(String imageName, String name, int count) {
        this.imageName = imageName;
        this.name = name;
        this.count = count;
    }
    /**
     * An accessor to get the String within the variable imageName
     * @return the string within imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * An mutator write a string into the imageName variable
     * @param imageName a String for the imageName variable
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * An accessor to get the String within the variable name
     * @return the string within name
     */
    public String getName() {
        return name;
    }

    /**
     * An mutator write a string into the name variable
     * @param name a String for the name variable
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * An accessor to get the integer within the variable count
     * @return the integer within count
     */
    public int getCount() {
        return count;
    }

    /**
     * An mutator write a integer into the count variable
     * @param count an integer for the count variable
     */
    public void setCount(int count) {
        this.count = count;
    }
}
