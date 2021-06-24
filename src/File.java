import java.sql.Timestamp;

public class File extends StorageItem
{
    private String extension;
    private String content;

    /**
     * getter for extension attribute
     * @return the extension of file
     */
    public String getExtension()
    {
        return this.extension;
    }

    /**
     * initialize class attributes
     */
    public File(String name, String extension)
    {
        super(name);
        this.extension = extension;
        this.content = "";
    }

    /**
     * getter for the size of the file
     * which is the length of the content string
     * @return the size
     */
    @Override
    public int getSize()
    {
        return this.content.length();
    }

    /**
     * getter for name of the file
     * @return the name of the file including its extension
     */
    @Override
    public String getName()
    {
        return this.name + "." + this.extension;
    }

    /**
     * add content to existing content in the file
     * by concatenating new content string to existing content string
     */
    public void addContent(String contentToAdd)
    {
        this.content = this.content + contentToAdd;
    }

    /**
     * print file size, date of creation, and the content of the file
     */
    public void printContent()
    {
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
