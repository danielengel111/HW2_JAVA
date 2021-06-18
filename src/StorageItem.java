import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public abstract class StorageItem
{
    private String name;
    private Date date;

    public String getName()
    {
        return this.name;
    }

    public Date getDate()
    {
        return this.date;
    }

    StorageItem(String name)
    {
        this.name = name;
        this.date = createDate();
    }

    public Date createDate()
    {
        Timestamp maxDate = new Timestamp(2021 - 1900, 12, 31, 23, 59, 59, 0);
        Timestamp minDate = new Timestamp(2017 - 1900, 1, 1, 0, 0, 0, 0);
        long range = maxDate.getTime() - minDate.getTime();
        long randTime = Math.abs(Main.rnd.nextLong()) % range;
        return new Date(minDate.getTime() + randTime);
    }

    public abstract int getSize();

    void printTree(SortingField field)
    {

    }
}
