class LightBulbs {
    private String blubType;
    private String dimmerType;
    private String energySavings;
    private String findDimmerTypeInstructions;

    public String getBulbType() {
        return bulbType;
    }

    public String getDimmerType() {
        return dimmerType;
    }

    public String getEnergySavings() {
        return energySavings;
    }

    public String getFindDimmerTypeInstructions() {
        return findDimmerTypeInstructions;
    }

    public void setBlubType(String blubType) {
        this.blubType = blubType;
    }

    public void setEnergySavings(String energySavings) {
        this.energySavings = energySavings;
    }

    public void setFindDimmerTypeInstructions(String findDimmerTypeInstructions) {
        this.findDimmerTypeInstructions = findDimmerTypeInstructions;
    }
}