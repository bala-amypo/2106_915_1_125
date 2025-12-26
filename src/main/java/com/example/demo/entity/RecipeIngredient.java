package com.example.demo.entity;

public class RecipeIngredient {
    private Long id;
    private MenuItem menuItem;
    private Ingredient ingredient;
    private Double quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public MenuItem getMenuItem() { return menuItem; }
    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }
    public Ingredient getIngredient() { return ingredient; }
    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
}