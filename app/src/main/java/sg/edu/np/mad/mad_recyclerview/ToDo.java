package sg.edu.np.mad.mad_recyclerview;

public class ToDo {
    private String Name;

    public ToDo(String name){
        this.Name = name;
    };

    public String getName() {
        return Name;
    }

    public void setName(String newName){
        this.Name = newName;
    }
}
