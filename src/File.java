public class File extends StorageItem
{
    private String extension;
    private String content;

    public String getExtension()
    {
        return this.extension;
    }

    public File(String name, String extension)
    {
        super(name);
        this.extension = extension;
        this.content = "";
    }

    @Override
    public int getSize()
    {
        return this.content.length();
    }

    public String getName()
    {
        return getName() + "." + this.extension;
    }

    public void addContent(String contentToAdd)
    {
        this.content = this.content + contentToAdd;
    }

    public void printContent()
    {
        System.out.println(this.getName() + " Size: " + this.getSize() + "MB Created: " + getDate());
        System.out.println(this.content);
    }
}
