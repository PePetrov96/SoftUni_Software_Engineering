package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setAlive();
        setMagic(magic);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setAlive() {
        isAlive = this.health > 0;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        int remainingDamage = points;

        if (remainingDamage > this.protection) {
            remainingDamage -= this.protection;
            this.protection = 0;
        } else {
            this.protection -= remainingDamage;
            remainingDamage = 0;
        }

        this.health -= remainingDamage;

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.health == 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s%n" +
                "Health: %d%n" +
                "Protection: %d%n" +
                "Magic: %s%n",
                getClass().getSimpleName(), getUsername(), getHealth(), getProtection(), getMagic().getName());
    }
}