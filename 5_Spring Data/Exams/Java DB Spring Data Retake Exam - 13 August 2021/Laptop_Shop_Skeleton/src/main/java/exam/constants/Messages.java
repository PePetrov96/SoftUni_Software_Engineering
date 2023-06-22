package exam.constants;

public enum Messages {
    ;
    public static final String INVALID_TOWN = "Invalid Town%n";
    public static final String TOWN_IMPORTED = "Successfully imported Town %s%n"; //name
    public static final String INVALID_SHOP = "Invalid Shop%n";
    public static final String SHOP_IMPORTED = "Successfully imported Shop %s - %.0f%n"; //name + income
    public static final String INVALID_CUSTOMER = "Invalid Customer%n";
    public static final String CUSTOMER_IMPORTED = "Successfully imported Customer %s %s - %s%n"; //first_name – last_name - email
    public static final String INVALID_LAPTOP = "Invalid Laptop%n";
    public static final String LAPTOP_IMPORTED = "Successfully imported Laptop %s - %.2f - %d - %d%n"; //mac_address + cpu + ram + storage

    public static final String EXPORT_LAPTOP = """
            Laptop - %s
            *Cpu speed - %.2f
            **Ram - %d
            ***Storage - %d
            ****Price - %.2f
            #Shop name - %s
            ##Town - %s%n%n""";
}
