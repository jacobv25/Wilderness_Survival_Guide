package edu.miracosta.finalprojecttest.model.enviroment;
/**
 * Animal.java: A class that creates an animal object to describe their parameters.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */

public class Tip
{
    private String tipName;
    private String tipDescription;
    private String tipImage;

    /**
     * Default constructor, in case there are no parameters given
     */
    public Tip()
    {
        tipName = "";
        tipDescription = "";
        tipImage = "";
    }

    /**
     * A full consturctor used to create an object with specific parameters passed in
     * @param tipName - The name of the tip
     * @param tipDescription - The description of the tip
     * @param tipImage - The image of the tip
     */
    public Tip(String tipName, String tipDescription, String tipImage) {
        this.tipName = tipName;
        this.tipDescription = tipDescription;
        this.tipImage = tipImage;
    }

    /**
     * An accessor to get the String within the variable tipName
     * @return the string within tipName
     */
    public String getTipName() {
        return tipName;
    }

    /**
     * An mutator write a string into the tipName variable
     * @param tipName a String for the tipName variable
     */
    public void setTipName(String tipName) {
        this.tipName = tipName;
    }

    public String getTipDescription() {
        return tipDescription;
    }

    /**
     * An mutator write a string into the tipImage variable
     * @param tipDescription a String for the tipImage variable
     */
    public void setTipDescription(String tipDescription) {
        this.tipDescription = tipDescription;
    }

    /**
     * An accessor to get the String within the variable tipImage
     * @return the string within tipImage
     */
    public String getTipImage() {
        return tipImage;
    }

    /**
     * An mutator write a string into the tipImage variable
     * @param tipImage a String for the tipImage variable
     */
    public void setTipImage(String tipImage) {
        this.tipImage = tipImage;
    }
}
