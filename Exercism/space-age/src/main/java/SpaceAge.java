//Earth: orbital period 365.25 Earth days, or 31557600 seconds
// Mercury: orbital period 0.2408467 Earth years
// Venus: orbital period 0.61519726 Earth years
// Mars: orbital period 1.8808158 Earth years
// Jupiter: orbital period 11.862615 Earth years
// Saturn: orbital period 29.447498 Earth years
// Uranus: orbital period 84.016846 Earth years
// Neptune: orbital period 164.79132 Earth years
// So if you were told someone were 1,000,000,000 
//seconds old, you should be able to say that they're 31.69 Earth-years old.

class SpaceAge {
    private double age;
    private double second;

    SpaceAge(double seconds) {
        this.second=seconds;
        this.age =(double) Math.round((seconds/31557600f) * 100) / 100;
    }

    double getSeconds() {
        return second;
    }

    double onEarth() {
        return age;
    }

    double onMercury() {
        return (double) Math.round((age/0.2408467f) * 100) / 100;
    }

    double onVenus() {
        return (double) Math.round((age/0.61519726f) * 100) / 100;
    }

    double onMars() {
        return (double) Math.round((age/1.8808158f) * 100) / 100;
    }

    double onJupiter() {
        return (double) Math.round((age/11.862615f) * 100) / 100;
    }

    double onSaturn() {
        return (double) Math.round((age/29.447498f) * 100) / 100;
    }

    double onUranus() {
        return (double) Math.round((age/84.016846f) * 100) / 100;
    }

    double onNeptune() {
        return (double) Math.round((age/164.79132f) * 100) / 100;
    }

}
