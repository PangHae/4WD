public abstract class Props {
    protected String propName;
    protected int probability;
    protected int actionRequire;

    Props(String propName){
        this.propName = propName;
    }
    public abstract int _harvest();
}
