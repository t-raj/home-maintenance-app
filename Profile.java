class Profile {
    private String name;
    private int snoozePreference;
    private Heater userHeater;
    private LightBulbs userLightBulbs;
    private Windows userWindows;

    public String getName() {
        return name;
    }

    public int getSnoozePreference() {
        return snoozePreference;
    }

    public Heater getUserHeater() {
        return userHeater;
    }

    public LightBulbs getUserLightBulbs() {
        return userLightBulbs;
    }

    public Windows getUserWindows() {
        return userWindows;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnoozePreference(int snoozePreference) {
        this.snoozePreference = snoozePreference;
    }

    public void setUserHeater(Heater userHeater) {
        this.userHeater = userHeater;
    }

    public void setUserLightBulbs(LightBulbs userLightBulbs) {
        this.userLightBulbs = userLightBulbs;
    }

    public void setUserWindows(Windows userWindows) {
        this.userWindows = userWindows;
    }
}