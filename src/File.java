import java.sql.Timestamp;

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

    @Override
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
        /**
         * print file size, date of creation, and the content of the file
         */
        Timestamp t = new Timestamp(getDate().getTime());
        System.out.println(this.getName()
                + " Size: " + this.getSize() + "MB Created: " + t);
        System.out.println(this.content);
    }

    /**
     * getter for content attribute
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * set the 'extension' attribute
     * @param extension - the new extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * set the 'content' attribute
     * @param content - the new content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
