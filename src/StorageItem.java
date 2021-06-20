import javax.naming.Name;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public abstract class StorageItem
{
    protected String name;
    protected final Date date;
    public static final String SEPARATOR = "|    ";

    public String getName()
    {
        return this.name;
    }

    /**
     * setter for 'name' attribute
     * @param name the name for the instance
     */
    public void setName(String name){
        this.name = name;
    }

    public Date getDate()
    {
        return this.date;
    }

    public StorageItem(String name)
    {
        this.name = name;
        this.date = createDate();
    }

    public Date createDate()
    {
        Timestamp maxDate = new
                Timestamp(2021 - 1900, 12,
                31, 23, 59, 59, 0);
        Timestamp minDate = new
                Timestamp(2017 - 1900, 1,
                1, 0, 0, 0, 0);
        long range = maxDate.getTime() - minDate.getTime();
        long randTime = Math.abs(Main.rnd.nextLong()) % range;
        return new Date(minDate.getTime() + randTime);
    }

    public abstract int getSize();

    public void printTree(SortingField field)
    {
        if(this instanceof File){
            System.out.println(this.getName());
            return;
        }
        ((Folder)this).sortList(field);
        //now the list is sorted according to the field given

        //printing the tree
        ((Folder) this).print("");
    }
}
