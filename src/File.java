public class File extends StorageItem
{
    protected String extension;
    File(String name, String extension)
    {
        super(name);
        this.extension = extension;
    }

    @Override
    public int getSize()
    {

    }

    public String getName()
    {
        return this.name + "." + this.extension;
    }

    public void printContent()
    {

    }
}
