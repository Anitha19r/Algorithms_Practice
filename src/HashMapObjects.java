import java.util.HashMap;
import java.util.HashSet;

public class HashMapObjects {

    String name;
    int age;

    public HashMapObjects(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof HashMapObjects))
            return false;
        HashMapObjects HashMapObjects = (HashMapObjects) obj;
        return HashMapObjects.getAge() == this.getAge()
                && HashMapObjects.getName() == this.getName();
    }

    // commented    
      @Override
        public int hashCode() {
            int result=17;
            result=31*result+age;
            result=31*result+(name!=null ? name.hashCode():0);
            return result;
        }
     
    public static void main(String[] args) {
        HashMapObjects HashMapObjects = new HashMapObjects("rajeev", 24);
        HashMapObjects HashMapObjects1 = new HashMapObjects("rajeev", 25);
        HashMapObjects HashMapObjects2 = new HashMapObjects("rajeev", 24);

        HashSet<HashMapObjects> HashMapObjectss = new HashSet<HashMapObjects>();
        HashMapObjectss.add(HashMapObjects);
        System.out.println(HashMapObjectss.contains(HashMapObjects2));
        System.out.println("HashMapObjects.hashCode():  " + HashMapObjects.hashCode()
        + "  HashMapObjects2.hashCode():" + HashMapObjects2.hashCode());
    }
}