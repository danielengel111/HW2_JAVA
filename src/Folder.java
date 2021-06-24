import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Folder extends StorageItem
{
    private ArrayList<StorageItem> itemList;

    /**
     * initialize class attributes
     */
    public Folder(String name)
    {
        super(name);
        this.itemList = new ArrayList<>();
    }

    /**
     * add item to folder given that no item
     * with identical name already exists in folder
     * @return true if succeeded in adding the item,
     * otherwise return false
     */
    public boolean addItem(StorageItem item)
    {
        for(StorageItem curItem : itemList)
        {
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
                    return ((Folder)curItem).findFile(path.substring(i+1));
        }
        return null; //found no such item
    }

    /**
     * iterates through all items in the folder and sum their size
     * @return the sum
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

    /**
     * sorts the itemList according to the sorting field given
     * @param field - sorting by this field
     */
    public void sortList(SortingField field){
        switch(field){
            case NAME://sorting by name
                itemList.sort(Comparator.comparing(StorageItem::getName));
                break;
            case SIZE://sorting by size
                itemList.sort(Comparator.comparing(StorageItem::getSize).
                        thenComparing(StorageItem::getName));
                break;
            case DATE://sorting by date
                itemList.sort(Comparator.comparing(StorageItem::getDate).
                        thenComparing(StorageItem::getName));
        }
        for(StorageItem item:itemList)//sort every nested folder
            if(item instanceof Folder)
                ((Folder)item).sortList(field);
    }

    /**
     * prints the folder, and all of its items
     * @param prefix - the start of the current printing (separators to print
     *               beforehand)
     */
    public void print(String prefix){
        System.out.println(prefix + this.getName());
        prefix += SEPARATOR;//add another separator
        for(StorageItem item:itemList){
            if(item instanceof File) {//if that's a file, just print its name
                System.out.println(prefix + item.getName());
                continue;
            }
            ((Folder)item).print(prefix);
            //otherwise it's a folder, print the nested folder
        }
    }
}
