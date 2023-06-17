package com.example.football.constants;

public enum Messages {
    ;
    public static final String INVALID_TOWN = "Invalid Town%n";
    public static final String TOWN_IMPORTED = "Successfully imported Town %s - %d%n";
    public static final String INVALID_TEAM = "Invalid Team%n";
    public static final String TEAM_IMPORTED = "Successfully imported Team %s - %d%n";
    public static final String INVALID_STAT = "Invalid Stat%n";
    public static final String STAT_IMPORTED = "Successfully imported Stat %.2f - %.2f - %.2f%n";
    public static final String INVALID_PLAYER = "Invalid Player%n";
    public static final String PLAYER_IMPORTED = "Successfully imported Player %s %s - %s%n";
    public static final String EXPORT_PLAYERS = """
            Player - %s %s
                Position - %s
                Team - %s
                Stadium - %s%n""";
}
