import java.util.ArrayList;
import java.util.Date;

public class Folder extends StorageItem
{
    private ArrayList<StorageItem> itemList;

    public Folder(String name)
    {
        super(name);
        this.itemList = new ArrayList<>();
    }

    public boolean addItem(StorageItem item)
    {
        for(StorageItem curItem : itemList)
        {
            if(curItem instanceof File && item instanceof File)
            {
                if(curItem.getName() == item.getName() &&
                        ((File) curItem).getExtension() ==
                                ((File) item).getExtension())
                {
                    return false;
                }
            }
            else if(curItem instanceof Folder && item instanceof Folder)
            {
                if(curItem.getName() == item.getName())
                {
                    return false;
                }
            }
        }
        itemList.add(item);
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
        for(StorageItem item : this.itemList)
        {
            size_sum += item.getSize();
        }
        return size_sum;
    }
}
