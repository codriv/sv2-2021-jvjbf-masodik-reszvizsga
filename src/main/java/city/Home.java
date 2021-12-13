package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (levels > 3) {
            throw new IllegalArgumentException("Maximum 3 levels!");
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    public int calculateNumberOfPeopleCanFit() {
        return (getArea() * getLevels()) / SQUARE_METERS_NEED_PER_PERSON;
    }
}