import java.util.ArrayList;
import java.util.Date;

public class Folder extends StorageItem
{
    private ArrayList<StorageItem> item_list;

    public Folder(String name)
    {
        super(name);
        item_list = new ArrayList<>();
    }

    public boolean addItem(StorageItem item)
    {
        for(StorageItem x : item_list)
        {
            if(x instanceof File && item instanceof File)
            {
                if(((File) x).getName() == ((File) item).getName() && ((File) x).getExtension() == ((File) item).getExtension())
                {
                    return false;
                }
            }
            else if(x instanceof Folder && item instanceof Folder)
            {
                if(x.getName() == item.getName())
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
