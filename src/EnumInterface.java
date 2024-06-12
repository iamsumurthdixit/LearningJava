public enum EnumInterface implements LowerCase{
    MONDAY,
    TUESDAY,
    SUNDAY;

    // interface with enum is done so that each constant in enum can work with same functionality
    // again, any/all constants can override toLowerCase() implementation like EnumAbstract
    @Override
    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}