// The following code is for singleton pattern
class ConfigurationManager {
    private static ConfigurationManager instance;
    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
}