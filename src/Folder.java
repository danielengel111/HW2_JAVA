import java.util.ArrayList;
import java.util.Date;

public class Folder extends StorageItem
{
    protected ArrayList<StorageItem> item_list;

    Folder(String name)
    {
        super(name);
        this.item_list = null;
    }

    public boolean addItem(StorageItem item)
    {
        for(StorageItem x : item_list)
        {
            if(x instanceof File && item instanceof File)
            {
                if(x.name == item.name && ((File) x).extension == ((File) item).extension)
                {
                    return false;
                }
            }
            else if(x instanceof Folder && item instanceof Folder)
            {
                if(x.name == item.name)
                {
                    return false;
                }
            }
        }
        item_list.add(item);
        return true;
    }
/*
    public File findFile(String path)
    {

    }
*/
    @Override
    public int getSize()
    {
        int size_sum = 0;
        for(StorageItem item : this.item_list)
        {
            size_sum += item.getSize();
        }
        return size_sum;
    }
}
