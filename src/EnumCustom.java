public enum EnumCustom {
    MONDAY(101, "1st"),
    TUESDAY(102, "2nd"),
    WEDNESDAY(103, "3rd"),
    THURSDAY(104, "4rd"),
    FRIDAY(105, "5rd"),
    SATURDAY(106, "6rd"),
    SUNDAY(107, "7rd");

    private int val;
    private String comment;

    // this may look `default`, but it is always `private`
    EnumCustom(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }
    public String getComment() {
        return comment;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    // below method is static because it has to be directly accessed from class
    public static EnumCustom getEnumFromValue(int val) {
        for(EnumCustom e : EnumCustom.values()) {
            if(e.val == val) {
                return e;
            }
        }
        return null;
    }
}
