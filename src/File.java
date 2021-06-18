public class File extends StorageItem
{
    protected String extension;
    protected String content;

    File(String name, String extension)
    {
        super(name);
        this.extension = extension;
    }

    @Override
    public int getSize()
    {
        return this.content.length();
    }

    public String getName()
    {
        return this.name + "." + this.extension;
    }

    public void addContent(String contentToAdd)
    {
        this.content = this.content + contentToAdd;
    }

    public void printContent()
    {
        System.out.println(this.getName() + "Size: " + this.getSize() + "MB Created: " + this.date);
        System.out.println(this.content);
    }
}
