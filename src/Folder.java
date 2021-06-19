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
            /*if(curItem instanceof File && item instanceof File)
            {
                if(curItem.getName().equals(item.getName()) &&
                        ((File) curItem).getExtension().
                                equals(((File) item).getExtension()))
                {
                    return false;
                }
            }
            else if(curItem instanceof Folder && item instanceof Folder)
            {
                if(curItem.getName().equals(item.getName()))
                {
                    return false;
                }
            }*/
            if(curItem.getName().equals(item.getName()))
                return false;
        }
        itemList.add(item);
        return true;
    }

    /**
     * this function gets a path to a file and checks if there is a file in
     * in the path
     * if there is returns it, null otherwise
     * @param path - the path to the file
     * @return the file if exists and null otherwise
     */
    public File findFile(String path)
    {
        if(path==null)
            return null;
        int i = 0;
        while(i < path.length() && path.charAt(i) != '/')
            i++;
        // i is either path's length or the index of the first '/'
        String curName = path.substring(0, i); // getting the name of the next
        // storage item
        for(StorageItem curItem: itemList){
            if(curItem instanceof File)
                if(i == path.length() && curItem.getName().equals(curName))
                    // if i is not the length of the string, we are not at the
                    //end of the path. File can only be at the end
                    return (File)curItem;
            if(curItem instanceof Folder)
                // is it the next folder in the path?
                if(curItem.getName().equals(curName))
                    // return the file from the nested folder, if it is there
                    return ((Folder)curItem).findFile(path.substring(i));
        }
        return null; //found no such item
    }

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
