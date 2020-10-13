public final class ImmutableStudent {
    private final int id;
    private final String name;

    public ImmutableStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
