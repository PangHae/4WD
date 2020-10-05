public abstract class Props {
    protected String propName;
    protected int probability;
    protected int actionRequire;

    Props(String propName,int probability, int actionRequire){
        this.propName = propName;
        this.probability = probability;
        this.actionRequire = actionRequire;
    }
    public abstract int _harvest();
}
