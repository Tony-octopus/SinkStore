/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sinkstore;

/**
 *
 * @author User
 */
public class Sink {
    private String brand;
    private String model;
    private String material;
    private double price;
    private final int SINK_SERIAL_NUM;
    private static int numSinks = 0;
    
    public Sink(){
       this("Default_Brand", "DooDoo model", "Cardboard", 10.0); 
    }
    
    public Sink(String b, String mod, String mat, double p){
        this.brand = b;
        this.model = mod;
        this.material = mat;
        this.price = p;
        numSinks++;
        this.SINK_SERIAL_NUM = numSinks;
    }
    
    public String getBrand(){
        return this.brand;
    }
    
    public String getModel(){
        return this.model;
    }
    
    public String getMaterial(){
        return this.material;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public static int getNumSinks(){
        return numSinks;
    }
    
    public void setBrand(String b){
        this.brand = b;
    }
    
    public void setModel(String mod){
        this.model = mod;
    }
    
    public void setMaterial(String mat){
        this.material = mat;
    }
    
    public void setPrice(double p){
        this.price = p;
    }
    
    public static void setNumSinks(int n){
        numSinks = n;
    }
    
    @Override
    public String toString(){
        return (this.brand + ","
        + this.model + ","+ this.material + "," + this.price + "," + this.SINK_SERIAL_NUM);
    }
    
}
