import java.util.Date;

public abstract class StorageItem
{
    protected String name;
    protected Date date;

    StorageItem(String name)
    {
        this.name = name;
    }

    public abstract int getSize();

    void printTree(SortingField field)
    {

    }
}
