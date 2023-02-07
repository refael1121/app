package com.example.myapplicationrecipe;

public class Recipe {
    private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private Boolean favorite;

    public Recipe() {
        this.id = -1;
        this.name = "";
        this.ingredients = "";
        this.instructions = "";
        this.photo = null;
    }

    private byte[] photo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
