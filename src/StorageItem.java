public abstract class StorageItem
{
    protected String name;
    StorageItem(String name)
    {
        this.name = name;
    }

    public abstract int getSize();

    void printTree(SortingField field)
    {

    }
}
