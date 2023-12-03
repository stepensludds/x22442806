package com.mycompany.x22442806;

/**
 * This class represents an energy conversion system for solar panels.
 * It calculates the annual solar energy production, cost savings, and payback period.
 */
public class EnergyConversion {
    private double currentEnergyConsumption; // Annual energy consumption in kWh
    private double currentEnergyCost; // Annual energy cost in Euros
    private double solarPanelEfficiency; // Solar panel efficiency as a percentage
    private double solarPanelSize; // Solar panel size in square meters
    private double solarPanelCost; // Total solar panel cost in Euros

    // Default constructor initializes all values to zero
    public EnergyConversion() {
        this.currentEnergyConsumption = 0;
        this.currentEnergyCost = 0;
        this.solarPanelEfficiency = 0;
        this.solarPanelSize = 0;
        this.solarPanelCost = 0;
    }

    // Setters for each property
    public void setCurrentEnergyConsumption(double consumption) {
        this.currentEnergyConsumption = consumption;
    }

    public void setCurrentEnergyCost(double cost) {
        this.currentEnergyCost = cost;
    }

    public void setSolarPanelEfficiency(double efficiency) {
        this.solarPanelEfficiency = efficiency;
    }

    public void setSolarPanelSize(double size) {
        this.solarPanelSize = size;
    }

    public void setSolarPanelCost(double cost) {
        this.solarPanelCost = cost;
    }

    // Getters for each property
    public double getCurrentEnergyConsumption() {
        return currentEnergyConsumption;
    }

    public double getCurrentEnergyCost() {
        return currentEnergyCost;
    }

    public double getSolarPanelEfficiency() {
        return solarPanelEfficiency;
    }

    public double getSolarPanelSize() {
        return solarPanelSize;
    }

    public double getSolarPanelCost() {
        return solarPanelCost;
    }

    // Calculates the annual solar energy production based on panel size, efficiency, and average daily sunlight hours
    public double calculateAnnualSolarEnergyProduction(double averageDailySunlightHours) {
        double efficiencyDecimal = solarPanelEfficiency / 100;
        double dailyEnergyProduction = solarPanelSize * efficiencyDecimal * averageDailySunlightHours;
        return dailyEnergyProduction * 365;
    }

    // Calculates the annual energy cost savings based on the annual energy production and the original annual energy cost
    public double calculateAnnualEnergyCostSavings(double averageDailySunlightHours, double annualEnergyCost) {
        double annualEnergyProduction = calculateAnnualSolarEnergyProduction(averageDailySunlightHours);
        double newEnergyConsumption = currentEnergyConsumption - annualEnergyProduction;
        double originalAnnualEnergyCost = annualEnergyCost;
        double newAnnualEnergyCost = (newEnergyConsumption / currentEnergyConsumption) * originalAnnualEnergyCost;
        return originalAnnualEnergyCost - newAnnualEnergyCost;
    }

    // Calculates the payback period based on the cost of the solar panel system and the annual energy cost savings
    public double calculatePaybackPeriod(double averageDailySunlightHours, double annualEnergyCost) {
        double annualEnergyCostSavings = calculateAnnualEnergyCostSavings(averageDailySunlightHours, annualEnergyCost);
        return solarPanelCost / annualEnergyCostSavings;
    }
}
