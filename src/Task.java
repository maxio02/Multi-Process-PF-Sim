public class Task {
    private int size;
    private int[] calls;

    public Task(int[] calls, int size){
        this.calls = calls;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getCalls() {
        return calls;
    }

    public void setCalls(int[] calls) {
        this.calls = calls;
    }

}
